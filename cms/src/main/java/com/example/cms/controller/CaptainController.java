package com.example.cms.controller;
import com.example.cms.model.entity.Team;

import com.example.cms.model.entity.Captain;
import com.example.cms.model.repository.CaptainRepository;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaptainController {

    @Autowired
    private final CaptainRepository captainRepository;

    public CaptainController(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }


    // Get all captains
    @GetMapping
    List<Captain> retrieveAllCaptains() {return captainRepository.findAll();}

    // Captain adds player
    //FINISH LATER
//    @PutMapping("/captain/{userID}")
//    Captain



}
