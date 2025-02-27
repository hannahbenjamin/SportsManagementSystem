package com.example.cms.model.repository;

import com.example.cms.model.entity.Division;
import com.example.cms.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
    List<Team> findByDivision(Division division);
}
