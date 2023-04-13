package com.SafetyNet.repository;

import com.SafetyNet.model.Firestation;
import com.SafetyNet.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRepository {
    private final DataHandler dataHandler;

    public PersonRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
    public List<Person> findAllPersons(){
        return  dataHandler.getData().getPersons();
    }
    public void addPerson(Person person){
        dataHandler.getData().getPersons().add(person);
    }
    public Person updatePerson(Person person){

        dataHandler.getData().getPersons();
        dataHandler.getData().getPersons().add(person);
        return person;
    }
    public void deletePerson(Person person){
        List<Person> persons = dataHandler.getData().getPersons();

        Person person2=new Person();
        for (Person person1 : persons) {
            if ((person1.getLastName().equals(person.getLastName())) &&( person1.getFirstName().equals(person.getFirstName()))) {
               person2=person1;

            }

        }
        persons.remove(person2);
        dataHandler.getData().setPersons(persons);
    }
//update

    public void update(List<Person> persons) {
        dataHandler.getData().setPersons(persons);
    }

}
