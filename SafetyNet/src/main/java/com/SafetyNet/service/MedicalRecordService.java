package com.SafetyNet.service;

import com.SafetyNet.model.MedicalRecord;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    public MedicalRecord save(MedicalRecord medicalRecord) {
        return medicalRecord;
    }

    public MedicalRecord update(MedicalRecord medicalRecord) {
        return medicalRecord;
    }

    public void delete(MedicalRecord medicalRecord) {
    }
}
