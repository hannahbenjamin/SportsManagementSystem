package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "divisions")

public class Division {
    @Id
    private long divisionID;

    @NotEmpty
    private String divisionName;

    // Need to figure out this
    // dictionary of tuples
    // key: (teamA, teamB)
    // value: (scoreA, scoreB)

    // FOREIGN KEY FROM GAME
    @NotEmpty
    private Dictionary standings;

    // list of tuples
    // (teamA, teamB, date, time, location)
    @NotEmpty
    private List schedule;

    private ArrayList<Team> teams;
}
