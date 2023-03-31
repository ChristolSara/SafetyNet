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


//    @PostMapping(value="/firestation")
//    public Firestation ajouterFirestation(@RequestBody Firestation firesation){
//        return firestationService.save(firesation);
//    }
//
//    @PutMapping(value="/firestation")
//    public Firestation mettreAjourFirestation(Firestation firestation){
//        return firestationService.update(firestation);
//    }
//    @DeleteMapping(value = "/firestation")
//    public void supprimerFirestation(Firestation firestation){
//        firestationService.delete(firestation);
//
//    }





    @GetMapping(value="/allFireStations")
    public List<Firestation> findAllFireStations(){
        return firestationService.findAllFireStations();
    }


    @GetMapping(value="/allFireStations/{number}")
    public List<Firestation> findAllFireStationsNumber(String nbr){
        return firestationService.findAllFireStationsNumber(nbr);
    }






}
