package com.SafetyNet.repository;

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

}
