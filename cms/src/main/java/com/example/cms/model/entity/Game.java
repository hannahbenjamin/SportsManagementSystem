package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

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

    @DateTimeFormat
    private LocalDateTime datetime;

    @NotEmpty
    private String location;

    @ManyToOne
    @JoinColumn(name = "team1ID", nullable = false)
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2ID", nullable = false)
    private Team team2;

    @Nullable
    private int teamScore1;

    @Nullable
    private int teamScore2;

    @NotEmpty
    private String gameStatus;
    // upcoming, completed

    @ManyToOne
    @Nullable
    @JoinColumn(name = "refereeID")
    private Referee referee;

    @ManyToOne
    @JoinColumn(name = "leagueID")
    private League league;
}
