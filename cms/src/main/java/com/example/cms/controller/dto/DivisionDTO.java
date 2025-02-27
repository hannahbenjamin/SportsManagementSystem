package com.example.cms.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DivisionDTO {
    private long divisionID;
    private String divisionName;
    private List<TeamDTO> teams;
    private List<GameDTO> schedule;
}

