package com.example.cms.controller.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
