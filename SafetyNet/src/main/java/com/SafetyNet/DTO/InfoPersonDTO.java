package com.SafetyNet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoPersonDTO {

    private String firstName;
    private String lastName;
    private String adress;
    private String mail ;
    private String age;

    private String[] medications;
    private String[] allergies;

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String name) {
        this.lastName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getMedications() {
        return medications;
    }

    public void setMedications(String[] medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return List.of(allergies);
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies.toArray(new String[0]);
    }
}
