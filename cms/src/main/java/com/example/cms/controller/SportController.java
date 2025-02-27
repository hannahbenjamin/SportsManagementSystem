package com.example.cms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sports")
@RequiredArgsConstructor
public class SportController {
//    private final SportService sportService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<SportDTO> getSport(@PathVariable long id) {
//        return ResponseEntity.ok(sportService.getSportById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<SportDTO> createSport(@RequestBody SportDTO sportDTO) {
//        return ResponseEntity.ok(sportService.createSport(sportDTO));
//    }
}
