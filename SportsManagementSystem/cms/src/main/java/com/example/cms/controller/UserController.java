package com.example.cms.controller;


import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.*;
import com.example.cms.model.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private final UserRepository repository;
    private final RefereeRepository refereeRepository;
    private final CaptainRepository captainRepository;
    private final PlayerRepository playerRepository;
    private final AdminRepository adminRepository;

    public UserController(UserRepository repository, RefereeRepository refereeRepository, CaptainRepository captainRepository, PlayerRepository playerRepository, AdminRepository adminRepository) {
        this.repository = repository;
        this.refereeRepository = refereeRepository;
        this.captainRepository = captainRepository;
        this.playerRepository = playerRepository;
        this.adminRepository = adminRepository;
    }

    // FIND ALL USERS
    @GetMapping("/users")
    List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    // RETRIEVE USER based on userId
//    @GetMapping("/users/{userId}")
//    User retrieveUser(@PathVariable("userId") Long userId) {
//        return repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException(userId));
//    }

    @PostMapping("/login/{role}")
    public ResponseEntity<?> loginByRole(
            @PathVariable String role,
            @RequestParam String email,
            @RequestParam String password) {

        User user = null;

        switch (role.toLowerCase()) {
            case "captain":
                user = captainRepository.findByEmailAndPassword(email, password);
                break;
            case "player":
                user = playerRepository.findByEmailAndPassword(email, password);
                break;
            case "admin":
                user = adminRepository.findByEmailAndPassword(email, password);
                break;
            case "referee":
                user = refereeRepository.findByEmailAndPassword(email, password);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
// ONLY NEW THING THAT CAN BE DELTED
    @PostMapping("/users/create")
    public ResponseEntity<String> createUser(
            @RequestParam String userID,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {
        try {
            switch (role.toLowerCase()) {
                case "captain":
                    Captain captain = new Captain();
                    captain.setUserID(userID);
                    captain.setFirstName(firstName);
                    captain.setLastName(lastName);
                    captain.setEmail(email);
                    captain.setPassword(password);
                    captain.setRole(role);
                    captainRepository.save(captain);
                    break;

                case "player":
                    Player player = new Player();
                    player.setUserID(userID);
                    player.setFirstName(firstName);
                    player.setLastName(lastName);
                    player.setEmail(email);
                    player.setPassword(password);
                    player.setRole(role);
                    playerRepository.save(player);
                    break;

                case "referee":
                    Referee referee = new Referee();
                    referee.setUserID(userID);
                    referee.setFirstName(firstName);
                    referee.setLastName(lastName);
                    referee.setEmail(email);
                    referee.setPassword(password);
                    referee.setRole(role);
                    refereeRepository.save(referee);
                    break;

                case "admin":
                    Admin admin = new Admin();
                    admin.setUserID(userID);
                    admin.setFirstName(firstName);
                    admin.setLastName(lastName);
                    admin.setEmail(email);
                    admin.setPassword(password);
                    admin.setRole(role);
                    adminRepository.save(admin);
                    break;

                default:
                    return ResponseEntity.badRequest().body("Invalid role specified.");
            }

            return ResponseEntity.ok("User created successfully as " + role);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating user: " + e.getMessage());
        }
    }

}


