package com.SafetyNet.service;

import com.SafetyNet.DTO.InfoPersonDTO;
import com.SafetyNet.DTO.InfoHabitantDTO;
import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.model.Person;

import com.SafetyNet.repository.FireStationRepository;
import com.SafetyNet.repository.MedicalRecordsRepository;
import com.SafetyNet.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;

    public PersonService(PersonRepository personRepository, MedicalRecordsRepository medicalRecordsRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }

//    public Person save(Person person) {
//        return person;
//    }
//
//    public Person update(Person person) {
//        return (person);
//    }
//
//    public void delete(Person person) {
    //   }


    public List<Person> fibdAllPersons() {
        return personRepository.findAllPersons();
    }

    public List<String> findAllMails() {

        List<Person> persons = personRepository.findAllPersons();
        List<String> mails = new ArrayList<>();


        for (Person person : persons) {

            mails.add(person.getEmail());

        }

        return mails;
    }

    //chercher les emails par rapport au city
    public List<String> findAllMailscity(String city) {

        List<Person> persons = personRepository.findAllPersons();
        List<String> mailsCity = new ArrayList<>();


        for (Person person : persons) {

            if (city.equals(person.getCity())) {
                mailsCity.add(person.getEmail());
            }


        }

        return mailsCity;
    }

    //retourne une list des n telephone des résidents qui apartients a la mm caserne
    public List<String> phoneAlert(String fnbr) {

        List<Person> persons = personRepository.findAllPersons();
        List<Firestation> firestations = fireStationRepository.findAllFireStations();
        List<String> phones = new ArrayList<>();
        List<String> fires = new ArrayList<>();

        for (Firestation firestation : firestations) {

            if (fnbr.equals(firestation.getStation())) {

                fires.add(firestation.getAddress());
            }
        }


        for (int i = 0; i < fires.size(); i++) {
            for (Person person : persons) {
                if (person.getAddress().equals(fires.get(i))) {

                    phones.add(person.getPhone());
                }
            }
        }
        return phones;
    }

//retourner les info d'une personne avc param first- et lastname

    public List<InfoPersonDTO> personInfo(String firstName, String lastName) throws ParseException {

        List<Person> persons = personRepository.findAllPersons();
        List<MedicalRecord> medicalRecords = medicalRecordsRepository.findAllMedicalRecords();
        List<InfoPersonDTO> infoPersonDTOs = new ArrayList<InfoPersonDTO>();

        for (Person person : persons) {

            if ((person.getFirstName().equals(firstName)) && (person.getLastName().equals(lastName))) {

                InfoPersonDTO infoPersonDTO = new InfoPersonDTO();

                infoPersonDTO.setFirstName(person.getFirstName());
                infoPersonDTO.setlastName(person.getLastName());
                infoPersonDTO.setAdress(person.getAddress());
                infoPersonDTO.setMail(person.getEmail());


                for (MedicalRecord medicalRecord : medicalRecords) {
                    if ((person.getFirstName().equals(medicalRecord.getFirstName())) && (person.getLastName().equals(medicalRecord.getLastName()))) {

                        infoPersonDTO.setAge(medicalRecord.getBirthdate());
                        infoPersonDTO.setAllergies(List.of(medicalRecord.getAllergies()));
                        infoPersonDTO.setMedications(medicalRecord.getMedications());
                        infoPersonDTO.setAge(String.valueOf(computeAge(medicalRecord.getBirthdate())));

                        infoPersonDTOs.add(infoPersonDTO);
                    }
                }

            }

        }
        return infoPersonDTOs;
    }


//fonction qui permet de compter l'age a partir de date de naissance

    public Integer computeAge(String age) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.parse(age, formatter);


        Period p = Period.between(birthday, today);
        return p.getYears();
    }

    //function qui rend le informations de habitant apartir de l'adress saisie
    public List<InfoHabitantDTO> infoHabitant(String adss) throws ParseException {
        List<Person> persons = personRepository.findAllPersons();
        List<MedicalRecord> medicalRecords = medicalRecordsRepository.findAllMedicalRecords();
        List<Firestation> firestations = fireStationRepository.findAllFireStations();

        List<InfoHabitantDTO> infoHabitantDTOS = new ArrayList<InfoHabitantDTO>();

        for (Person person : persons) {
            if (person.getAddress().equals(adss)) {
                InfoHabitantDTO infoHabitantDTO = new InfoHabitantDTO();

                infoHabitantDTO.setLastName(person.getLastName());
                infoHabitantDTO.setFirstName(person.getFirstName());
                infoHabitantDTO.setPhone(person.getPhone());
                infoHabitantDTO.setAdress(person.getAddress());
                for (Firestation firestation : firestations) {
                    if (firestation.getAddress().equals(person.getAddress())) {
                        infoHabitantDTO.setStation(firestation.getStation());
                        for (MedicalRecord medicalRecord : medicalRecords) {
                            if (person.getFirstName().equals(medicalRecord.getFirstName())) {
                                infoHabitantDTO.setAge(String.valueOf(computeAge(medicalRecord.getBirthdate())));
                                infoHabitantDTO.setAllergies(medicalRecord.getAllergies());
                                infoHabitantDTO.setMedications(medicalRecord.getMedications());

                            }


                        }
                    }
                }
                infoHabitantDTOS.add(infoHabitantDTO);
            }

        }


        return infoHabitantDTOS;
    }
}
