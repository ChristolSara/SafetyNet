package com.SafetyNet.contoller;

import com.SafetyNet.DTO.InfoPersonDTO;
import com.SafetyNet.DTO.InfoHabitantDTO;
import com.SafetyNet.model.Person;
import com.SafetyNet.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }



//    @PostMapping(value="/person")
//    public Person ajouterPerson(@RequestBody Person person){
//       return personService.save(person);
//    }
//
//    @PutMapping(value="/person")
//    public Person mettreAjourPerson(Person person){
//        return personService.update(person);
//    }
//    @DeleteMapping(value = "/person")
//    public void supprimerPerson(Person person){
//        personService.delete(person);
//    }


    @GetMapping(value="/allPersons")
    public List<Person> findAllPersons(){

        return personService.fibdAllPersons();
        }
     @GetMapping(value="/allMails")
        public List <String> findAllMail(){

        return personService.findAllMails();
        }
    @GetMapping(value="/allMails/{city}")
    public List <String> findAllMailcity(@PathVariable String city){

        return personService.findAllMailscity(city);
    }
    @GetMapping(value="phoneAlert/firestation={fnbr}")
    public List<String>phoneAlertNumber(@PathVariable String fnbr){
        return personService.phoneAlert(fnbr);
    }


    @GetMapping(value="personInfo/firstName={firstName}/lastName={lastName}")
    public List<InfoPersonDTO>personInfo(@PathVariable String firstName,@PathVariable String lastName) throws ParseException {
        return personService.personInfo(firstName,lastName);
    }


    @GetMapping(value="fire/adress={adss}")
    public List<InfoHabitantDTO> infoHabitant(@PathVariable String adss) throws ParseException {
        return personService.infoHabitant(adss);
    }



}
