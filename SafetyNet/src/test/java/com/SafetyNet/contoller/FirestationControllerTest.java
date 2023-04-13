package com.SafetyNet.contoller;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.service.FirestationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FirestationControllerTest {
    @Autowired
    FirestationController firestationController;
    @Autowired
    FirestationService firestationService;

    @Test
    void ajouterFirestation() {
        Firestation firestation=new Firestation("22 rue 13444","7");
        firestationController.ajouterFirestation(firestation);
        List<Firestation > firestation1 = firestationService.findAllFireStationsNumber("7");
        Firestation firestation2= firestation1.stream().filter(p->p.getStation().equals("7")).collect(Collectors.toList()).stream().findFirst().get();

        assertEquals(firestation.getAddress(),firestation2.getAddress());

    }

    @Test
    void mettreAjourFirestation() {

        List<Firestation> firestations=firestationService.findAllFireStations();
        Firestation firestation1=new Firestation("1 rue henri barbusse","7");
        firestations.add(firestation1);

        //crer lobjet de la mise a jour
        Firestation firestation2=new Firestation("1 rue henri barbusse","64");

        firestationController.mettreAjourFirestation(firestation2);
        //
         Firestation firestationList =firestations.stream()
                 .filter(f -> f.getAddress().equals(firestation1.getAddress()))
                 .findAny().get();
         //assert
        assertEquals(firestation2.toString(),firestationList.toString());


    }

    @Test
    void supprimerFirestation() {
        List<Firestation> firestations=firestationService.findAllFireStations();
        Firestation firestation1=new Firestation("1 rue hhh","9");
        firestations.add(firestation1);

        firestationController.supprimerFirestation(firestation1);
        List<Firestation> firestations2=firestationService.findAllFireStations();


        assertEquals(firestations2.contains(firestation1.toString()),false);


    }

    @Test
    void allFireStations() {
        List<Firestation> firestations=firestationService.findAllFireStations();

        Firestation firestation=new Firestation("23 rue henri ","22");
        firestations.add(firestation);
        List<Firestation> firestationList= firestationController.AllFireStations();

        assertEquals(firestationList.contains(firestation),true);
    }

    @Test
    void findAllFireStationsNumber() {
        List<Firestation> firestationList = firestationService.findAllFireStations();
        Firestation firestation=new Firestation(" 12 rue hhh","6");
        firestationList.add(firestation);
      List<Firestation> firestations = firestationController.findAllFireStationsNumber("6");


      assertEquals(firestations.contains(firestation),true);
    }
}