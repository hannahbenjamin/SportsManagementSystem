package com.example.cms.controller;

import com.example.cms.controller.dto.AdminDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {
    //private final AdminService adminService;

//    @GetMapping("/{id}")
//    public ResponseEntity<AdminDTO> getAdmin(@PathVariable long id) {
//        return ResponseEntity.ok(adminService.getAdminById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO) {
//        return ResponseEntity.ok(adminService.createAdmin(adminDTO));
//    }
}

