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
        List<MedicalRecord> medicalRecords = medicalRecordController.findAllMedicalRecords();
        assertEquals(medicalRecords.size(),23);

    }

    @Test
    void addMedicalRecord() {

        MedicalRecord medicalRecord1=new MedicalRecord("sara","kaouar","12/12/2011", new String[]{"hhhhhh"}, new String[]{"kkkkkkk"});

        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecords();

        medicalRecordController.addMedicalRecord(medicalRecord1);
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
        List<MedicalRecord> medicalRecords=medicalRecordService.findAllMedicalRecords();

        MedicalRecord medicalRecord1= new MedicalRecord("sara","kaouar","31/07/1992",new String[]{"hhhhhh"}, new String[]{"kkkkkkk"});

        medicalRecords.add(medicalRecord1);

        MedicalRecord medicalRecord2= new MedicalRecord("sara","kaouar","31/12/1992",new String[]{""}, new String[]{"kk"});

        medicalRecordController.miseAjourMedicalRecord(medicalRecord2);

        //recuperer la valeur de la medical records de  la list principal
        MedicalRecord medicalRecordList = medicalRecords.stream()
                .filter(medicalRecord -> medicalRecord.getLastName().equals(medicalRecord1.getLastName()))
                .filter(medicalRecord -> medicalRecord.getFirstName().equals(medicalRecord1.getFirstName()))
                .findAny().get();


        assertEquals(medicalRecord1.toString(),medicalRecordList.toString());

    }

    @Test
    void supprimermedicalRecord() {
        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecords();
        MedicalRecord medicalRecord =new MedicalRecord("Eric","Cadigan","08/06/1945",new String[]{
                "tradoxidine:400mg"},new String[]{});
       int size1= medicalRecords.size();
        medicalRecordController.supprimermedicalRecord(medicalRecord);
       int size = medicalRecords.size();
        assertEquals(size1-1,size);
    }
}
