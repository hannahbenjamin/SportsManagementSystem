package com.example.cms.model.repository;

import com.example.cms.model.entity.Game;
import com.example.cms.model.entity.Player;
import com.example.cms.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    // Get all teams
    @Query("SELECT t FROM Team t")
    List<Team> findAllTeams();

    // Get a specific team by ID
    @Query("SELECT t FROM Team t WHERE t.teamID = :teamID")
    Team findTeamById(Long teamID);

    // Get all players in a team
    @Query("SELECT p FROM Player p WHERE :team MEMBER OF p.teams")
    List<Player> findPlayersByTeam(Team team);

    // Get the captain of a team
    @Query("SELECT t.captain FROM Team t WHERE t.teamID = :teamID")
    Player findCaptainByTeamId(Long teamID);

    // Get the schedule of a team (all games where the team is playing)
    @Query("SELECT g FROM Game g WHERE g.teamA.teamID = :teamID OR g.teamB.teamID = :teamID")
    List<Game> findScheduleByTeamId(Long teamID);
}
