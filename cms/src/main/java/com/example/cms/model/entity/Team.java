package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teams")

public class Team {

    @Id
    private String teamID;

    @NotEmpty
    private String teamName;

    @NotEmpty
    private int teamCapacity;

    @NotEmpty
    private ArrayList<Player> players;

    // FIX FOREIGN KEY
    @OneToMany
    @JoinColumn(name = "captainID")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "sportID")
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "divisionID")
    private Division division;

    @NotEmpty
    private String ranking;

    public Team(String teamID, String teamName, String sportID, String divisionID){
        this.teamID = teamID;
        this.teamName = teamName;
        this.sport = sport;
        this.division = division;
    }
}
