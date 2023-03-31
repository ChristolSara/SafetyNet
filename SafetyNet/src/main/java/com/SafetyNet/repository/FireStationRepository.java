package com.SafetyNet.repository;

import com.SafetyNet.model.Firestation;
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

}
