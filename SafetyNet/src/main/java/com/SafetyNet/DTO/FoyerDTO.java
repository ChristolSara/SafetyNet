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
    private List<InfoHabitantDTO> infoHabitant;


}
