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

    public List<MedicalRecord> findAllMedicalRecords() {
        return dataHandler.getData().getMedicalRecords();
    }

    public void addMedicalRecords(MedicalRecord medicalRecord) {
        dataHandler.getData().getMedicalRecords().add(medicalRecord);
    }

    public void updateMedicalRecords(MedicalRecord medicalRecord) {

        List<MedicalRecord> medicalRecords=dataHandler.getData().getMedicalRecords();
        for (MedicalRecord medicalRecord1:medicalRecords){
            if (medicalRecord1.getLastName().equals(medicalRecord.getLastName()) && medicalRecord1.getFirstName().equals(medicalRecord.getFirstName()))
            {
                medicalRecord1.setFirstName(medicalRecord.getFirstName());
                medicalRecord1.setLastName(medicalRecord.getLastName());
                medicalRecord1.setBirthdate(medicalRecord.getBirthdate());
                medicalRecord1.setMedications(medicalRecord.getMedications());
                medicalRecord1.setAllergies(medicalRecord.getAllergies());


            }
        }


    }

    public void deleteMedicalRecords(MedicalRecord medicalRecord) {
        List<MedicalRecord> medicalRecords = dataHandler.getData().getMedicalRecords();
        int index = 0;
        for (MedicalRecord medicalRecord2 : medicalRecords) {

            if((medicalRecord2.getLastName().equals(medicalRecord.getLastName())) && (medicalRecord2.getFirstName().equals(medicalRecord.getFirstName()))){

                medicalRecords.remove(medicalRecord2);
                dataHandler.getData().setMedicalRecords(medicalRecords);

            }

        }

    }

    public MedicalRecord selectMedicalRecordByFirstNameAndLastName(String firstName, String lastName) {
        List<MedicalRecord> medicalRecords = dataHandler.getData().getMedicalRecords();
        MedicalRecord medicalRecord1 =new MedicalRecord();
        for(MedicalRecord medicalRecord:medicalRecords){
            if(medicalRecord.getFirstName().equals(firstName) &&(medicalRecord.getLastName().equals(lastName))){

                medicalRecord1.setFirstName(medicalRecord.getFirstName());
                medicalRecord1.setLastName(medicalRecord.getLastName());
                medicalRecord1.setAllergies(medicalRecord.getAllergies());
                medicalRecord1.setMedications(medicalRecord.getMedications());
                medicalRecord1.setBirthdate(medicalRecord.getBirthdate());
            }
        }

        return medicalRecord1;
    }
}
