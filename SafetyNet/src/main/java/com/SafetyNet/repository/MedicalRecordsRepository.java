package com.SafetyNet.repository;

import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalRecordsRepository {

    private final DataHandler dataHandler;

    public MedicalRecordsRepository(DataHandler dataHandler) {

        this.dataHandler = dataHandler;
    }
    public List<MedicalRecord> findAllMedicalRecords(){
        return  dataHandler.getData().getMedicalRecords();
    }

}
