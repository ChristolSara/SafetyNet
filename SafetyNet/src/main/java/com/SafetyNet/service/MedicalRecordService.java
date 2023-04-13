package com.SafetyNet.service;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.repository.FireStationRepository;
import com.SafetyNet.repository.MedicalRecordsRepository;
import com.SafetyNet.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;

    public MedicalRecordService(PersonRepository personRepository, MedicalRecordsRepository medicalRecordsRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }
    //traitement des CRUD
    public List<MedicalRecord> findAllMedicalRecords() {

        return medicalRecordsRepository.findAllMedicalRecords();
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordsRepository.addMedicalRecords(medicalRecord);
    }

    public void update(MedicalRecord medicalRecord) {
        List<MedicalRecord> medicalRecords=medicalRecordsRepository.findAllMedicalRecords();

        for(MedicalRecord medicalRecord1:medicalRecords){
            if(medicalRecord1.getFirstName().equals(medicalRecord.getFirstName()) && medicalRecord1.getLastName().equals(medicalRecord.getLastName())){
                medicalRecord1.setMedications(medicalRecord.getMedications());
                medicalRecord1.setBirthdate(medicalRecord.getBirthdate());
                medicalRecord1.setAllergies(medicalRecord.getAllergies());
            }
        }medicalRecordsRepository.update(medicalRecords);

    }

    public void delete(MedicalRecord medicalRecord) {
        medicalRecordsRepository.deleteMedicalRecords(medicalRecord);
    }

}