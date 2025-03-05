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

    @NotEmpty
    @DateTimeFormat
    private LocalDateTime datetime;

    @NotEmpty
    private String location;

    @ManyToOne
    @JoinColumn(name = "team1_ID")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_ID")
    private Team team2;

    @NotEmpty
    private int teamScore1;

    @NotEmpty
    private int teamScore2;

    @NotEmpty
    private String gameStatus;
    // upcoming, completed

    @Nullable
    @ManyToOne
    @JoinColumn(name="refereeID")
    private Referee referee;
}
