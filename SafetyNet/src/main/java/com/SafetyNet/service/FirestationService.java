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
      List<Firestation> result = new ArrayList<Firestation>();

      for(Firestation firestation:firestations){
          if(firestation.getStation().equals(Nbr)){
              Firestation firestation1= new Firestation();
              firestation1.setStation(firestation.getStation());
              firestation1.setAddress(firestation.getAddress());
              result.add(firestation1);
          }
      }
        return result;
    }

    public void save(Firestation firesation) {
        fireStationRepository.addFireStation(firesation);

    }

    public void update(Firestation firestation) {
        List<Firestation> firestations = fireStationRepository.findAllFireStations();
        for (Firestation firestation1:firestations) {
            if (firestation1.getAddress().equals(firestation.getAddress())) {
                firestation1.setAddress(firestation.getAddress());
                firestation1.setStation(firestation.getStation());

            }

        }
        fireStationRepository.update(firestations);


    }

    public void delete(Firestation firestation) {
        fireStationRepository.deleteFirestations(firestation);
    }
    public List<Firestation> AllFireStations(){
        return fireStationRepository.findAllFireStations();
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
