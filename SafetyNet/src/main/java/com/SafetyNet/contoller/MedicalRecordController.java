package com.SafetyNet.contoller;

import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.service.MedicalRecordService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {
    private MedicalRecordService medicalRecordService;
    @PostMapping(value="/medicalRecord")
    public MedicalRecord ajouterMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordService.save(medicalRecord);
    }
    @PutMapping(value = "/medicalRecord")
    public MedicalRecord miseAjourMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordService.update(medicalRecord);
    }

    @DeleteMapping(value = "/medicalRecord")
    public void supprimermedicalRecord(MedicalRecord medicalRecord){
        medicalRecordService.delete(medicalRecord);
    }

}
