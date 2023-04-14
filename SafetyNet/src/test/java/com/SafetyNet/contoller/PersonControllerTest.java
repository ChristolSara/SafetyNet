package com.SafetyNet.contoller;

import com.SafetyNet.DTO.InfoHabitantDTO;
import com.SafetyNet.DTO.InfoHabitantStationDTO;
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
        List<Person> personList = personController.findAllPersons();
        assertEquals(persons.size(),personList.size());
    }

    @Test
    void findAllMail() {
        //preparation
        List<Person> persons=personService.fibdAllPersons();
        Person person = new Person("sara", "toto", "1 rue ", "aix", "00000", "kjhlyg@gmail");
        //excution
        persons.add(person);
       List<String> mails= personController.findAllMail();


//        List<InfoPersonDTO> reslt = personService.personInfo("sara","toto");
//       InfoPersonDTO resultStream = reslt.stream().filter(p->p.getFirstName().equals("sara")).collect(Collectors.toList()).stream().findFirst().get();

        assertTrue(mails.contains(String.valueOf(person.getEmail())));

    }

    @Test
    void infoHabitantStation() throws ParseException {

      InfoHabitantStationDTO infoHabit= personController.infoHabitantStation("2");


    }

    @Test
    void enfantList() {
    }

    @Test
    void phoneAlertNumber() {
        List<String> phone = personController.phoneAlertNumber("2");
        assertEquals(phone.size(),4);
        assert(phone).contains("841-874-6513");

    }

    @Test
    void infoHabitant() throws ParseException {

        List<Person> personList=personService.fibdAllPersons();
        Person person1=personList.get(0);

       List<InfoHabitantDTO> info =  personController.infoHabitant(person1.getAddress());

       assertEquals(info.get(0).getFirstName(),person1.getFirstName());
        assertEquals(info.get(2).getStation(),"3");
        assertEquals(info.get(1).getAdress(),person1.getAddress());

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

        List<String> getMail = personController.findAllMailcity("aix en provence");

        assertEquals(getMail.contains("kaouar@gmail.com"),true);


    }

    @Test
    void getListDtoFlood() {
    }
}