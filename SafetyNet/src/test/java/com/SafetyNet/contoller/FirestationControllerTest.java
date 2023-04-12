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
    }

    @Test
    void supprimerFirestation() {
    }

    @Test
    void allFireStations() {
    }

    @Test
    void findAllFireStationsNumber() {
    }
}