package com.example.cms.model.repository;

import com.example.cms.model.entity.Game;
import com.example.cms.model.entity.League;
import com.example.cms.model.entity.Team;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeagueRepository {

    // Get all leagues
    @Query("SELECT l FROM League l")
    List<League> findAllLeagues();

    // Get a specific league by ID
    @Query("SELECT l FROM League l WHERE l.leagueID = :leagueID")
    League findLeagueById(Long leagueID);

    // Get all teams in a league
    @Query("SELECT t FROM Team t WHERE t.league.leagueID = :leagueID")
    List<Team> findTeamsByLeagueId(Long leagueID);

    // Get all games in a league
    @Query("SELECT g FROM Game g WHERE g.league.leagueID = :leagueID")
    List<Game> findGamesByLeagueId(Long leagueID);
}
