package com.SafetyNet.service;

import com.SafetyNet.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public Person save(Person person) {
        return person;
    }

    public Person update(Person person) {
        return (person);
    }

    public void delete(Person person) {
    }
}
