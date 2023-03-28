package com.SafetyNet.contoller;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.Person;
import com.SafetyNet.service.FirestationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirestationController {
    private FirestationService firestationService;

    @PostMapping(value="/firestation")
    public Firestation ajouterFirestation(@RequestBody Firestation firesation){
        return firestationService.save(firesation);
    }

    @PutMapping(value="/firestation")
    public Firestation mettreAjourFirestation(Firestation firestation){
        return firestationService.update(firestation);
    }
    @DeleteMapping(value = "/firestation")
    public void supprimerFirestation(Firestation firestation){
        firestationService.delete(firestation);

    }


}
