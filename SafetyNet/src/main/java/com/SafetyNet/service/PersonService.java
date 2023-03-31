package com.SafetyNet.service;

import com.SafetyNet.contoller.DTO.InfoPersonDTO;
import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.model.Person;

import com.SafetyNet.repository.FireStationRepository;
import com.SafetyNet.repository.MedicalRecordsRepository;
import com.SafetyNet.repository.PersonRepository;
import org.springframework.stereotype.Service;

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

    public List<InfoPersonDTO> personInfo(String firstName, String lastName) {

        List<Person> persons = personRepository.findAllPersons();
        List<MedicalRecord> medicalRecords = medicalRecordsRepository.findAllMedicalRecords();
        List<InfoPersonDTO> infoPersonDTOs = new ArrayList<InfoPersonDTO>();

        for(Person person:persons){

            if((person.getFirstName().equals(firstName)) && (person.getLastName().equals(lastName))){

                for(InfoPersonDTO infoPersonDTO:infoPersonDTOs){

                    infoPersonDTO.setName(person.getLastName());
                    infoPersonDTO.setFirstName(person.getFirstName());
                    infoPersonDTO.setAdress(person.getAddress());
                    infoPersonDTO.setMail(person.getEmail());


                }
            }
        }


        return infoPersonDTOs;
    }


}
