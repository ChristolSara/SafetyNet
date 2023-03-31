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
    public List<MedicalRecord> findAllMedicalRecords(){

        return medicalRecordsRepository.findAllMedicalRecords();
    }


//    public MedicalRecord save(MedicalRecord medicalRecord) {
//        return medicalRecord;
//    }
//
//    public MedicalRecord update(MedicalRecord medicalRecord) {
//        return medicalRecord;
//    }
//
//    public void delete(MedicalRecord medicalRecord) {
//    }
}
