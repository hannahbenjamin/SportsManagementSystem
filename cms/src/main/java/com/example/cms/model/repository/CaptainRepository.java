package com.example.cms.model.repository;
import com.example.cms.model.entity.Team;

import com.example.cms.model.entity.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    @Query("SELECT c FROM Captain c")
    List<Captain> findAllCaptains();

    // ADD PLAYER TO TEAM
    // does this by changing the player's teamID to the captains teamID
    @Modifying
    @Transactional
    @Query(value = "UPDATE Player p SET p.teamID = (SELECT c.teamID FROM Captain c WHERE c.userID = :captainId) WHERE p.userID = :playerId", nativeQuery = true)
    int addPlayerToTeam(@Param("captainId") Long captainId, @Param("playerId") Long playerId);


    // Captain removes player
    @Modifying
    @Transactional
    @Query(value = "UPDATE Player p SET p.teamID = NULL WHERE p.userID = :playerId AND EXISTS (SELECT 1 FROM Captain c WHERE c.userID = :captainId AND c.role = 'captain' AND c.teamID = p.teamID)", nativeQuery = true)
    int removePlayerFromTeam(@Param("captainId") Long captainId, @Param("playerId") Long playerId);
}
