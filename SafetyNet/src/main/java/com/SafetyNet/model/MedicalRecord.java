package com.SafetyNet.model;

public class MedicalRecord {

    private Person person;
    private  String[] medications;
    private  String[] allergies;

    public MedicalRecord() {
    }

    public MedicalRecord(Person person, String[] medications, String[] allergies) {
        this.person = person;
        this.medications = medications;
        this.allergies = allergies;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String[] getMedications() {
        return medications;
    }

    public void setMedications(String[] medications) {
        this.medications = medications;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }
}
