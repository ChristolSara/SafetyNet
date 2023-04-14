package com.SafetyNet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoHabitantStationDTO {
    private List<InfoFirePersonDTO> habitantDTOList;

    private  String majeur;
    private String mineur;

}
