package com.SafetyNet.contoller;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.service.FirestationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirestationController {
    private FirestationService firestationService;

    public FirestationController(FirestationService firestationService) {
        this.firestationService = firestationService;
    }
//traitement des crud

    @PostMapping(value="/firestation")
    public void ajouterFirestation(@RequestBody Firestation firesation){
        firestationService.save(firesation);
    }

    @PutMapping(value="/firestation")
    public void mettreAjourFirestation(@RequestBody Firestation firestation){
         firestationService.update(firestation);
    }
    @DeleteMapping(value = "/firestation")
    public void supprimerFirestation(@RequestBody Firestation firestation){
        firestationService.delete(firestation);

    }

    @GetMapping(value="/allFireStations")
    public List<Firestation> AllFireStations(){
        return firestationService.AllFireStations();
    }


    @GetMapping(value="/allFireStations/{number}")
    public List<Firestation> findAllFireStationsNumber(String nbr){
        return firestationService.findAllFireStationsNumber(nbr);
    }






}
