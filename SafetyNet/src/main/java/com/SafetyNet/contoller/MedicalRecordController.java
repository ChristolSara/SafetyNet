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
    public void addMedicalRecord(@RequestBody MedicalRecord medicalRecord){
         medicalRecordService.addMedicalRecord(medicalRecord);
    }
    @PutMapping(value = "/medicalRecord")
    public MedicalRecord miseAjourMedicalRecord(@RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.update(medicalRecord);
    }

    @DeleteMapping(value = "/medicalRecord")
    public void supprimermedicalRecord(@RequestBody MedicalRecord medicalRecord){
        medicalRecordService.delete(medicalRecord);
    }

}
