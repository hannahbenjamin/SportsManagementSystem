package com.example.cms.model.repository;

import com.example.cms.model.entity.Referee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, Long> {

    @Query("SELECT r FROM Referee r")
    List<Referee> findAllReferees();

    // Update game status to "Finished" (only if referee is assigned to the game)
    @Modifying
    @Transactional
    @Query(value = "UPDATE Game g SET g.status = 'Finished' WHERE g.id = :gameId" +
    " AND EXISTS (SELECT 1 FROM Referee r WHERE r.userID = :refereeUserId AND :gameId MEMBER OF r.gameIDs)", nativeQuery = true)
    int updateGameStatus(@Param("refereeUserId") Long refereeUserId, @Param("gameId") Long gameId);

}
