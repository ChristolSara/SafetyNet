package com.SafetyNet.contoller;

import com.SafetyNet.model.MedicalRecord;
import com.SafetyNet.model.Person;
import com.SafetyNet.service.MedicalRecordService;
import com.SafetyNet.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class MedicalRecordControllerTest {
@Autowired
MedicalRecordController medicalRecordController;
@Autowired
    MedicalRecordService medicalRecordService;

    @Test
    void findAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecords();
        assertEquals(medicalRecords.size(),23);

    }

    @Test
    void addMedicalRecord() {

        MedicalRecord medicalRecord1=new MedicalRecord("sara","kaouar","12/12/2011", new String[]{"hhhhhh"}, new String[]{"kkkkkkk"});

        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecords();

        medicalRecords.add(medicalRecord1);
        boolean  exciste = false;
       
        for(MedicalRecord medicalRecord:medicalRecords){
            if(medicalRecord.getFirstName().equals("sara")){
              exciste=true;
            }else{
                exciste = false;
            }
        }

        assertEquals(true,exciste);

    }

    @Test
    void miseAjourMedicalRecord() {
    }

    @Test
    void supprimermedicalRecord() {
        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecords();
        MedicalRecord medicalRecord =new MedicalRecord("Eric","Cadigan","08/06/1945",new String[]{
                "tradoxidine:400mg"},new String[]{});
        medicalRecords.remove(medicalRecord);
        assertEquals(medicalRecords.size(),22);
    }
}
