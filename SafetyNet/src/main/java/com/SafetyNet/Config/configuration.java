package com.SafetyNet.Config;



import com.SafetyNet.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Event;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;

import java.io.*;


import java.io.FileReader;

@Component
public class configuration {


    ObjectMapper mapper = new ObjectMapper();

    //JSON file to Java object
    Person obj = mapper.readValue(new File("data.json"), Person.class);


    public configuration() throws IOException {
    }
}
