package com.example.cms.controller.exceptions;

import com.example.cms.model.entity.Player;
import com.example.cms.model.entity.User;
import com.example.cms.model.repository.PlayerRepository;
import com.example.cms.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
//    private final PlayerService playerService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable long id) {
//        return ResponseEntity.ok(playerService.getPlayerById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
//        return ResponseEntity.ok(playerService.createPlayer(playerDTO));
//    }


    @Autowired
    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    // FIND ALL USERS
    @GetMapping("/players")
    List<Player> retrieveAllUsers() {
        return repository.findAllPlayers();
    }
//
//    // RETRIEVE USER based on userId - Will not include, because we have the userId
//    @GetMapping("/players/{userId}")
//    User retrieveUser(@PathVariable("userId") Long userId) {
//        return repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException(userId));
//    }
}
