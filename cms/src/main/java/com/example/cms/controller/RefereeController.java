package com.example.cms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/referees")
@RequiredArgsConstructor
public class RefereeController {
//    private final RefereeService refereeService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RefereeDTO> getReferee(@PathVariable long id) {
//        return ResponseEntity.ok(refereeService.getRefereeById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<RefereeDTO> createReferee(@RequestBody RefereeDTO refereeDTO) {
//        return ResponseEntity.ok(refereeService.createReferee(refereeDTO));
//    }
}