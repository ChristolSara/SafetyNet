package com.SafetyNet.Config;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class configuration {

    public String Configuration() throws FileNotFoundException, IOException {
        // Le fichier d'entrée
        File file = new File("../data.json");

       return file.toString();
    }

}
