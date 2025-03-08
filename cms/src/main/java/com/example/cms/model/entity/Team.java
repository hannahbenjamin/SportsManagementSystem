package com.example.cms.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;


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
    @Nullable
    private String ranking;

    // CONNECT PLAYERS TO TEAm
    @OneToMany(mappedBy = "team") // one team can have many players
    @Nullable
    private List<Player> players = new ArrayList<>();

    // CONNECT CAPTAIN TO TEAM
    @OneToOne
    @JoinColumn(name = "captainID") // Foreign key reference to the captain
    private Captain captain;

    // CONNECT TEAM TO LEAGUE
    @ManyToOne
    @JoinColumn(name = "leagueID")
    private League league;

    // HOME GAMES (TEAM 1)
    @OneToMany(mappedBy = "team1")
    private List<Game> homeGames = new ArrayList<>();

    // AWAY GAME (TEAM 2)
    @OneToMany(mappedBy = "team2")
    private List<Game> awayGames = new ArrayList<>();

    public Team(String teamID, String teamName, Captain captain, League league){
        this.teamID = teamID;
        this.teamName = teamName;
        this.league = league;
        this.captain = captain;
    }
}

