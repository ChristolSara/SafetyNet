package com.SafetyNet.contoller;

import com.SafetyNet.model.Person;
import com.SafetyNet.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private PersonService personService;

    @PostMapping(value="/person")
    public Person ajouterPerson(@RequestBody Person person){
       return personService.save(person);
    }

    @PutMapping(value="/person")
    public Person mettreAjourPerson(Person person){
        return personService.update(person);
    }
    @DeleteMapping(value = "/person")
    public void supprimerPerson(Person person){
        personService.delete(person);
    }


}
