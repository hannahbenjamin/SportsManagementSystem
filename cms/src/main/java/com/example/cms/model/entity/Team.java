package com.example.cms.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
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
    private String ranking;

    @OneToMany(mappedBy = "team") // one team can have many players
    private List<Player> players = new ArrayList<>(); // Initialize the list

    @OneToOne(mappedBy = "team") // References the field in Captain class
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "leagueID")
    private League league;

    public Team(String teamID, String teamName, League league){
        this.teamID = teamID;
        this.teamName = teamName;
        this.league = league;
    }
}

