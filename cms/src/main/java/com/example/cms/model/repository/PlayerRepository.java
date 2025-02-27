package com.example.cms.model.repository;

import com.example.cms.model.entity.Player;
import com.example.cms.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeams(Team team);
}

