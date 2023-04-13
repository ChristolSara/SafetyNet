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
        List<Person> personList=personService.fibdAllPersons();
        //Person person= personList.get(0);


        Person person1=new Person("sara","aaa","1 rue hh","aix","000","ka@gmail.com");
        personService.addPerson(person1);

        Person person2=new Person("sara","aaa","ccc","ggg","777","lll@gmail.com");


        personController.mettreAjourPerson(person2);
        //assertEquals(person1.getPhone().toString(),"000");
        Person personInList = personList.stream()
                .filter(p -> p.getLastName().equals(person1.getLastName()))
                .filter(p -> p.getFirstName().equals(person1.getFirstName()))
                .findAny().get();

        assertTrue(personInList.toString().equals(person2.toString()));

    }

    @Test
    void supprimerPerson() {
        List<Person> personList=personService.fibdAllPersons();

        Person person1= personList.get(0);
        personController.supprimerPerson(person1);

        List<Person> personList1=personService.fibdAllPersons();

        assertEquals(personList1.contains(person1.toString()),false);

    }

    @Test
    void findAllPersons() {
        List<Person> persons = personService.fibdAllPersons();
        assertEquals(persons.size(),23);
    }

    @Test
    void findAllMail() {
        //preparation
        Person person = new Person("sara", "toto", "1 rue ", "aix", "00000", "kjhlyg@gmail");
        //excution
        personController.addPerson(person);

        Person person2 = personService.findPerson("sara", "toto");

//        List<InfoPersonDTO> reslt = personService.personInfo("sara","toto");
//       InfoPersonDTO resultStream = reslt.stream().filter(p->p.getFirstName().equals("sara")).collect(Collectors.toList()).stream().findFirst().get();

        assertEquals(person.getEmail(), person2.getEmail());

    }

    @Test
    void infoHabitantStation() {
    }

    @Test
    void enfantList() {
    }

    @Test
    void phoneAlertNumber() {
        List<String> phone = personService.phoneAlert(String.valueOf(2));
        assertEquals(phone.size(),4);
        assert(phone).contains("841-874-6513");

    }

    @Test
    void infoHabitant() throws ParseException {


    }

    @Test
    void listFoyer() {
    }

    @Test
    void personInfo() throws ParseException {

        List<InfoPersonDTO> listInfo= personController.personInfo("sara","kaouar");
        InfoPersonDTO infoPersonDTO=new InfoPersonDTO("sara","kaouar","1 rue henri barbusse","30","2",new String[]{""}, new String[]{"kk"});
         listInfo.add(infoPersonDTO);


       InfoPersonDTO  listResult = listInfo.stream()
               .filter(infoPersonDTO1 -> infoPersonDTO1.getFirstName().equals("sara"))
               .filter(infoPersonDTO1 -> infoPersonDTO1.getlastName().equals("kaouar"))

               .findAny().get();

       assertEquals(listResult.getAdress(),infoPersonDTO.getAdress());

    }

    @Test
    void findAllMailcity() {
        List<Person> persons=personService.fibdAllPersons();
        Person person=new Person("sara","kaouar","1 rue h ","aix en provence","005860266","kaouar@gmail.com");
        persons.add(person);

        List<String> getMail = personService.findAllMailscity("aix en provence");
        assertEquals(getMail.contains("kaouar@gmail.com"),true);


    }
}