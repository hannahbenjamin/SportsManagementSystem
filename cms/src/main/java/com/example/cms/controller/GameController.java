package com.example.cms.controller.exceptions;

import com.example.cms.controller.dto.GameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
//    private final GameService gameService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GameDTO> getGame(@PathVariable long id) {
//        return ResponseEntity.ok(gameService.getGameById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO) {
//        return ResponseEntity.ok(gameService.createGame(gameDTO));
//    }
}