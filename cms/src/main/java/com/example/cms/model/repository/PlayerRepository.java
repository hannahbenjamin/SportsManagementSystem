package com.example.cms.model.repository;

import com.example.cms.model.entity.Game;
import com.example.cms.model.entity.Player;
import com.example.cms.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p")
    List<Player> findAllPlayers();

    // Query to find the captain of a given team
    @Query("SELECT p FROM Player p WHERE p.team.id = :teamId AND p.isCaptain = true")
    Player findCaptainByTeamId(@Param("teamId") Long teamId);

    // Query to get all games for a player's team
    @Query("SELECT g FROM Game g WHERE g.team1.id = :teamId OR g.team2.id = :teamId")
    List<Game> findTeamSchedule(@Param("teamId") Long teamId);
}

