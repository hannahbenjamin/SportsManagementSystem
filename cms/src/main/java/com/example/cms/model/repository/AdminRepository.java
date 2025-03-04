package com.example.cms.model.repository;

import com.example.cms.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a")
    List<Admin> findAllAdmins();

    // Create a new league
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO League (leagueName, divisionNumber, gender, sport, schedule) VALUES (:leagueName, :divisionNumber, :gender, :sport, :schedule)", nativeQuery = true)
    int createLeague(@Param("leagueName") String leagueName,
                     @Param("divisionNumber") int divisionNumber,
                     @Param("gender") String gender,
                     @Param("sport") String sport,
                     @Param("schedule") String schedule);

    // Create a new team
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Team (teamName, captainUserID, leagueID, ranking) VALUES (:teamName, :captainUserID, :leagueID, :ranking)", nativeQuery = true)
    int createTeam(@Param("teamName") String teamName,
                   @Param("captainUserID") Long captainUserID,
                   @Param("leagueID") Long leagueID,
                   @Param("ranking") int ranking);

    // Assign a captain to a team
    @Modifying
    @Transactional
    @Query(value = "UPDATE Team t SET t.captainUserID = :captainUserID WHERE t.id = :teamId", nativeQuery = true)
    int assignCaptain(@Param("teamId") Long teamId, @Param("captainUserID") Long captainUserID);

    // Create a new game
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Game (leagueID, date, time, teamID1, teamID2, score, status) VALUES (:leagueID, :date, :time, :teamID1, :teamID2, :score, :status)", nativeQuery = true)
    int createGame(@Param("leagueID") Long leagueID,
                   @Param("date") String date,
                   @Param("time") String time,
                   @Param("teamID1") Long teamID1,
                   @Param("teamID2") Long teamID2,
                   @Param("score") int[] score,
                   @Param("status") String status);

    // Assign a referee to a game
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Game_Referee (game_id, referee_user_id) VALUES (:gameId, :refereeUserId)", nativeQuery = true)
    int assignReferee(@Param("refereeUserId") Long refereeUserId, @Param("gameId") Long gameId);

    // Update the game score (Admins have no restrictions)
    @Modifying
    @Transactional
    @Query(value = "UPDATE Game g SET g.score = :score WHERE g.id = :gameId", nativeQuery = true)
    int updateGameScore(@Param("gameId") Long gameId, @Param("score") int[] score);

    // Update game status (Admins have no restrictions)
    @Modifying
    @Transactional
    @Query(value = "UPDATE Game g SET g.status = :status WHERE g.id = :gameId", nativeQuery = true)
    int updateGameStatus(@Param("gameId") Long gameId, @Param("status") String status);
}

