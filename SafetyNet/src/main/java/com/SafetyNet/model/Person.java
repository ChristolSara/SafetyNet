package com.SafetyNet.model;


import java.util.Date;

public class Person {
    private Integer id;
    private String Name;
    private String lastName;
    private String mail;
    private String adress;
    private  String city;
    private Integer phone;
    private  Date birthday;
    private MedicalRecord medicalRecord;
    private Firestation firesation;

    public Person(Integer id, String name, String lastName, String mail, String adress, String city, Integer phone, Date birthday, MedicalRecord medicalRecord, Firestation firesation) {
        this.id = id;
        Name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.adress = adress;
        this.city = city;
        this.phone = phone;
        this.birthday = birthday;
        this.medicalRecord = medicalRecord;
        this.firesation = firesation;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Firestation getFiresation() {
        return firesation;
    }

    public void setFiresation(Firestation firesation) {
        this.firesation = firesation;
    }
}
