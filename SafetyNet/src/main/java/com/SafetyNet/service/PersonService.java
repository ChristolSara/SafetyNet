package com.SafetyNet.service;

import com.SafetyNet.DTO.*;

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
import java.util.stream.Collectors;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;
    private InfoHabitantStationDTO infoHabitant;

    public PersonService(PersonRepository personRepository, MedicalRecordsRepository medicalRecordsRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }

    ///   //traitement des crud

    public void addPerson(Person person) {
        personRepository.addPerson(person);

    }

    /////////////////
    public void update(Person person) {
        List<Person> persons = personRepository.findAllPersons();
        for (Person person1 : persons) {
            if (person1.getFirstName().equals(person.getFirstName()) && person1.getLastName().equals(person.getLastName())) {
                person1.setFirstName(person.getFirstName());
                person1.setLastName(person.getLastName());
                person1.setAddress(person.getAddress());
                person1.setPhone(person.getPhone());
                person1.setEmail(person.getEmail());
                person1.setCity(person.getCity());

            }

        }
        personRepository.update(persons);
    }

    ///////////////////
    public void deletePerson(Person person) {
        personRepository.deletePerson(person);
    }
//////////////////

    public List<Person> fibdAllPersons() {
        return personRepository.findAllPersons();
    }

    //traitement des requettes complexe
    public List<String> findAllMails() {

        List<Person> persons = personRepository.findAllPersons();
        List<String> mails = new ArrayList<>();
        for (Person person : persons) {
            mails.add(person.getEmail());
        }
        return mails;
    }

    //chercher les emails par rapport au city en utilisant les stream
    public List<String> findAllMailscity(String city) {

        List<Person> persons = personRepository.findAllPersons();
        List<String> mailsCity = new ArrayList<>();
        for (Person person : persons) {
            if (person.getCity().equals(city)) {
                mailsCity.add(person.getEmail());
            }
        }
        return mailsCity;
    }

    //trouver un person avc son nom et  prenom
    public Person findPerson(String fnm, String lnm) {

        List<Person> persons = personRepository.findAllPersons();

        Person person1 = new Person();

        for (Person person : persons) {
            if (person.getFirstName().equals(fnm) && person.getLastName().equals(lnm)) {

                person1.setLastName(person.getLastName());
                person1.setFirstName(person.getFirstName());
                person1.setAddress(person.getAddress());
                person1.setCity(person.getCity());
                person1.setEmail(person.getEmail());
                person1.setPhone(person.getPhone());
            }

        }
        return person1;
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

    public Integer computeAge(String age) {

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

    //cette method retourne les info dhabitant pa rapport à  leur stationfire
    public InfoHabitantStationDTO infoHabitantStation(Integer station_number) {

        List<Person> persons = personRepository.findAllPersons();
        List<MedicalRecord> medicalRecords = medicalRecordsRepository.findAllMedicalRecords();
        List<Firestation> firestations = fireStationRepository.findAllFireStations();

        List<InfoFirePersonDTO> habitantDTOList = new ArrayList<InfoFirePersonDTO>();
        InfoHabitantStationDTO infoHabitantStationDTO = new InfoHabitantStationDTO();

        int decompteMajeur = 0;
        int decompteMineur = 0;

        for (Firestation firestation : firestations) {
            if (firestation.getStation().equals(station_number.toString())) {
                for (Person person : persons) {
                    if (person.getAddress().equals(firestation.getAddress())) {
                        for (MedicalRecord medicalrecord : medicalRecords) {
                            if ((medicalrecord.getLastName().equals(person.getLastName())) && ((medicalrecord.getFirstName().equals(person.getFirstName())))) {
                                String age = String.valueOf(computeAge(medicalrecord.getBirthdate()));
                                if ((Integer.valueOf(age)) > 18) {
                                    decompteMajeur ++;

                                } else {
                                    decompteMineur++;
                                }
                                habitantDTOList.add(new InfoFirePersonDTO(person.getFirstName(), person.getLastName(), person.getAddress(), person.getPhone(), age));
                            }
                        }}}
        infoHabitantStationDTO.setHabitantDTOList(habitantDTOList);
        infoHabitantStationDTO.setMajeur(String.valueOf(decompteMajeur));
        infoHabitantStationDTO.setMineur(String.valueOf(decompteMineur));

    }}
        return infoHabitantStationDTO;
    }

    //cette method retourne des enfants et leur info par rapport à leur adress et etourne une liste des personne de meme foyer
    public List<EnfantDTO> enfantList(String adrs) throws ParseException {

        List<Person> persons = personRepository.findAllPersons();
        List<MedicalRecord> medicalRecords = medicalRecordsRepository.findAllMedicalRecords();
        List<Firestation> firestations = fireStationRepository.findAllFireStations();

        List<EnfantDTO> enfantDTOs = new ArrayList<EnfantDTO>();
        List<Person> personNibers = new ArrayList<Person>();

        for (Person person : persons) {
            if (person.getAddress().equals(adrs)) {

                personNibers.add(person);
                person.getFirstName();
                person.getLastName();
                for (MedicalRecord medicalRecord : medicalRecords) {

                    if (person.getFirstName().equals(medicalRecord.getFirstName()) && (computeAge(medicalRecord.getBirthdate()) < 18)) {
                        EnfantDTO enfantDTO = new EnfantDTO();
                        enfantDTO.setFirstName(person.getFirstName());
                        enfantDTO.setLastName(person.getLastName());
                        enfantDTO.setAge(String.valueOf(computeAge(medicalRecord.getBirthdate())));
                        enfantDTO.setAdress(person.getAddress());
                        enfantDTO.setPersonList(personNibers);
                        enfantDTOs.add(enfantDTO);
                    }
                }
            }
        }
        return enfantDTOs;
    }

    ////////////////////////////
    public List<FoyerDTO> getListDtoFlood(List<Integer> stations) throws ParseException {

        List<Firestation> firestationList = selectListFirestationByListStationNumbers(stations);

        List<InfoHabitantDTO> personFoyer = new ArrayList<InfoHabitantDTO>();

        List<FoyerDTO> foyerDTOS = new ArrayList<FoyerDTO>();

        for (Firestation firestation : firestationList) {
            InfoHabitantDTO infoHabitantDTO = new InfoHabitantDTO();
            infoHabitantDTO.setAdress(firestation.getAddress());

            List<Person> personList = personRepository.findAllPersons();

            for (Person person : personList) {
                MedicalRecord medicalRecord = medicalRecordsRepository.selectMedicalRecordByFirstNameAndLastName(person.getFirstName(), person.getLastName());
                Integer age = computeAge(medicalRecord.getBirthdate());
                infoHabitantDTO.setLastName(person.getLastName());
                infoHabitantDTO.setFirstName(person.getFirstName());
                infoHabitantDTO.setAge(age.toString());
                infoHabitantDTO.setAllergies(medicalRecord.getAllergies());
                infoHabitantDTO.setMedications(medicalRecord.getMedications());


            }
            personFoyer.add(infoHabitantDTO);
            foyerDTOS.add((FoyerDTO) personFoyer);
        }
        return foyerDTOS;
    }

            public List<Firestation> selectListFirestationByStationNumber (Integer stationNumber){
                List<Firestation> firestations = fireStationRepository.findAllFireStations();

                List<Firestation> firestationListToReturn = firestations.stream()
                        .filter(f -> f.getStation().equals(String.valueOf(stationNumber)))
                        .collect(Collectors.toList());


                return firestationListToReturn;
            }

            public List<Firestation> selectListFirestationByListStationNumbers (List < Integer > intList) {
                List<Firestation> firestationListToReturn = new ArrayList<>();
                for (Integer integer : intList) {
                    List<Firestation> firestationList = selectListFirestationByStationNumber(integer);
                    for (Firestation firestation : firestationList) {
                        firestationListToReturn.add(firestation);
                    }
                }
                return firestationListToReturn;
            }

            public List<Person> selectListPersonByAddress (String address){
                List<Person> persons = personRepository.findAllPersons();
                List<Person> personListToReturn = persons.stream()
                        .filter(p -> p.getAddress().equals(address))
                        .collect(Collectors.toList());
                return personListToReturn;
            }


    }
