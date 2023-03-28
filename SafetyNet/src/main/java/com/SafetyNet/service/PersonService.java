package com.SafetyNet.service;

import com.SafetyNet.model.Person;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PersonService {
    private Person person;



    public Person save(Person person) {
        return person;
    }

    public Person update(Person person) {
        return (person);
    }

    public void delete(Person person) {
    }
}
