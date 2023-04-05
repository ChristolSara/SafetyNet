package com.SafetyNet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoHabitantStationDTO {
    private List<InfoHabitantDTO> habitantDTOList;

    private  String majeur;
    private String mineur;
    public List<InfoHabitantDTO> getHabitantDTOList() {
        return habitantDTOList;
    }

    public void setHabitantDTOList(List<InfoHabitantDTO> habitantDTOList) {
        this.habitantDTOList = habitantDTOList;
    }

    public String getMineur() {
        return mineur;
    }

    public void setMineur(String mineur) {
        this.mineur = mineur;
    }

    public String getMajeur() {
        return majeur;
    }

    public void setMajeur(String majeur) {
        this.majeur = majeur;
    }
}
