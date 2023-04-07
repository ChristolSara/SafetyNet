package com.SafetyNet.service;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.Person;
import com.SafetyNet.repository.FireStationRepository;
import com.SafetyNet.repository.MedicalRecordsRepository;
import com.SafetyNet.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirestationService {



    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;

    public FirestationService(PersonRepository personRepository, MedicalRecordsRepository medicalRecordsRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }


    public List<Firestation> findAllFireStations(){
        return fireStationRepository.findAllFireStations();
    }
    public List<Firestation> findAllFireStationsNumber(String Nbr){

      List<Firestation> firestations=  fireStationRepository.findAllFireStations();


        return null ;
    }

    public Firestation save(Firestation firesation) {
        return firesation;
    }

    public Firestation update(Firestation firestation) {
        return firestation;
    }

    public void delete(Firestation firestation) {
    }


//    public Firestation save(Firestation firesation) {
//        return firesation;
//    }
//
//    public Firestation update(Firestation firestation) {
//        return firestation;
//    }
//
//    public void delete(Firestation firestation) {
//    }
}
