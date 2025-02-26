package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "games")
public class Game {
    @Id
    private long gameID;

    @NotEmpty
    @DateTimeFormat
    private LocalDateTime datetime;

    @NotEmpty
    private String location;

    @NotEmpty
    private String teamID1;

    @NotEmpty
    private String teamID2;

    @NotEmpty
    private int team1score;

    @NotEmpty
    private int team2score;

    @NotEmpty
    private String gameStatus;

    @ManyToOne
    @JoinColumn(name = "sportID")
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "divisionID")
    private Division division;
}
