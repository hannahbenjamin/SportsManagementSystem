package com.example.cms.controller;
import com.example.cms.controller.exceptions.CaptainNotFoundException;
import com.example.cms.controller.exceptions.PlayerNotFoundException;
import com.example.cms.model.entity.Team;

import com.example.cms.model.entity.Captain;
import com.example.cms.model.repository.CaptainRepository;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CaptainController {

    @Autowired
    private final CaptainRepository captainRepository;

    public CaptainController(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    // GET ALL CAPTAINS
    @GetMapping
    List<Captain> retrieveAllCaptains() {return captainRepository.findAll();}

    // RETRIEVE CAPTAIN
    @GetMapping("/captains/{captainId}")
    Captain retreiveCaptain(@PathVariable("captainId") Long userID){
        return captainRepository.findById(userID)
                .orElseThrow(() -> new CaptainNotFoundException(userID));
    }

    // ADD PLAYER TO TEAM
    @PostMapping("/{captainId}/addPlayer/{playerId}")
    @Transactional
    public void addPlayerToTeam(
            @PathVariable Long captainId, @PathVariable Long playerId) {captainRepository.addPlayerToTeam(captainId, playerId);}

    // REMOVE PLAYER TO TEAM
    @DeleteMapping("/{captainId}/removePlayer/{playerId}")
    @Transactional
    public void removePlayerFromTeam(
            @PathVariable Long captainId, @PathVariable Long playerId) {captainRepository.removePlayerFromTeam(captainId, playerId);}
}
