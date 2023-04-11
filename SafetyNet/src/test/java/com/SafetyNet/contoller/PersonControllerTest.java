package com.SafetyNet.contoller;

import com.SafetyNet.DTO.InfoPersonDTO;
import com.SafetyNet.model.Person;
import com.SafetyNet.service.PersonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonControllerTest {

    @Autowired
    PersonController personController;
    @Autowired
    PersonService personService;


    @Test
    void addPerson() throws ParseException {
        //preparation
        Person person = new Person("sara", "toto", "1 rue ", "aix", "00000", "kjhlyg@gmail");
        //excution
        personController.addPerson(person);

       Person person2 = personService.findPerson("sara", "toto");

//        List<InfoPersonDTO> reslt = personService.personInfo("sara","toto");
//       InfoPersonDTO resultStream = reslt.stream().filter(p->p.getFirstName().equals("sara")).collect(Collectors.toList()).stream().findFirst().get();

        assertEquals(person.getFirstName(), person2.getFirstName());

    }

    @Test
    void mettreAjourPerson() {
    }

    @Test
    void supprimerPerson() {
    }

    @Test
    void findAllPersons() {
    }

    @Test
    void findAllMail() {
    }

    @Test
    void infoHabitantStation() {
    }

    @Test
    void enfantList() {
    }

    @Test
    void phoneAlertNumber() {
    }

    @Test
    void infoHabitant() {
    }

    @Test
    void listFoyer() {
    }

    @Test
    void personInfo() {
    }

    @Test
    void findAllMailcity() {
    }
}