package com.SafetyNet.repository;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FireStationRepository {
    private final DataHandler dataHandler;

    public FireStationRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
    public List<Firestation> findAllFireStations(){

        return  dataHandler.getData().getFirestations();
    }
    public void addFireStation(Firestation firestation){
        dataHandler.getData().getFirestations().add(firestation);
    }
    public Firestation updateFireStation(Firestation firestation){
        dataHandler.getData().getFirestations();
        dataHandler.getData().getFirestations().add(firestation);
        return firestation;
    }
    public void deleteFirestations(Firestation firestation) {
        List<Firestation> firestations = dataHandler.getData().getFirestations();
        int index = 0;
        for (Firestation firestation1 : firestations) {

            if((firestation1.getStation().equals(firestation.getStation())) && (firestation1.getAddress().equals(firestation.getAddress()))){

                firestations.remove(firestation1);
                dataHandler.getData().setFirestations(firestations);

            }

        }

    }

    public void update(List<Firestation> firestations) {
        dataHandler.getData().setFirestations(firestations);
    }

}
