package com.SafetyNet.contoller;

import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.service.MedicalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordController {
    private MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }
    //traitement des CRUD
    @GetMapping(value="/allMedicalRecords")
    public List<MedicalRecord> findAllMedicalRecords(){
        return medicalRecordService.findAllMedicalRecords();
    }
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
