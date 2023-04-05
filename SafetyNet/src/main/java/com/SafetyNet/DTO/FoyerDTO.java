package com.SafetyNet.DTO;

import com.SafetyNet.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoyerDTO {
    private String stationNumber;
    private String adress;
    private List<Person> personFoyer;

    public String getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Person> getPersonFoyer() {
        return personFoyer;
    }

    public void setPersonFoyer(List<Person> personFoyer) {
        this.personFoyer = personFoyer;
    }
}
