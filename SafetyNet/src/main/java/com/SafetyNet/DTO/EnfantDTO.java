package com.SafetyNet.DTO;

import com.SafetyNet.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnfantDTO {
    private String Age;
    private String firstName;
    private String lastName;


    private String adress;
    private List<Person> personList;


}
