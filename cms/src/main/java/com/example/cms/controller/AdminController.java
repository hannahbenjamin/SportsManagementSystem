package com.example.cms.controller;

import com.example.cms.controller.dto.LeagueDTO;
import com.example.cms.model.entity.Admin;
import com.example.cms.model.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @CrossOrigin
    @RestController
    @RequestMapping("/admins")
    class AdminController {

        private final AdminRepository adminRepository;


        @Autowired
        AdminController(AdminRepository adminRepository) {
            this.adminRepository = adminRepository;
        }

        // Get all admins
        @GetMapping()
        List<Admin> retrieveAllAdmin() {
            return adminRepository.findAll();
        }

        // Create a new league
//        @PostMapping("/league")
//        String createLeague(@RequestBody LeagueDTO leagueDTO) {
//            try {
//                adminRepository.createLeague(
//                        leagueDTO.getLeagueName(),
//                        leagueDTO.getLeagueGender(),
//                        leagueDTO.getLeagueSport(),
//                        leagueDTO.getSchedule()
//                );
//                return "League created successfully.";
//            } catch (Exception e) {
//                return "Error creating league: " + e.getMessage();
//            }
//        }

        // Delete a league
        @DeleteMapping("/league/{leagueId}")
        String deleteLeague(@PathVariable Long leagueId) {
            try {
                adminRepository.deleteLeague(leagueId);
                return "League deleted successfully.";
            } catch (Exception e) {
                return "Error deleting league: " + e.getMessage();
            }
        }

        // Create a new team
        @PostMapping("/team")
        String createTeam(@RequestParam String teamName,
                          @RequestParam Long captainUserID,
                          @RequestParam Long leagueID,
                          @RequestParam int ranking) {
            try {
                adminRepository.createTeam(teamName, captainUserID, leagueID, ranking);
                return "Team created successfully.";
            } catch (Exception e) {
                return "Error creating team: " + e.getMessage();
            }
        }

        // Delete a team
        @DeleteMapping("/team/{teamId}")
        String deleteTeam(@PathVariable Long teamId) {
            try {
                adminRepository.deleteTeam(teamId);
                return "Team deleted successfully.";
            } catch (Exception e) {
                return "Error deleting team: " + e.getMessage();
            }
        }

        // Create a new game
        @PostMapping("/game")
        String createGame(@RequestParam Long leagueID,
                          @RequestParam String date,
                          @RequestParam String time,
                          @RequestParam Long teamID1,
                          @RequestParam Long teamID2,
                          @RequestParam int[] score,
                          @RequestParam String status) {
            try {
                adminRepository.createGame(leagueID, date, time, teamID1, teamID2, score, status);
                return "Game created successfully.";
            } catch (Exception e) {
                return "Error creating game: " + e.getMessage();
            }
        }

        // Delete a game
        @DeleteMapping("/game/{gameId}")
        String deleteGame(@PathVariable Long gameId) {
            try {
                adminRepository.deleteGame(gameId);
                return "Game deleted successfully.";
            } catch (Exception e) {
                return "Error deleting game: " + e.getMessage();
            }
        }

        // Assign captain to a team
        @PutMapping("/team/{teamId}/captain")
        String assignCaptain(@PathVariable Long teamId,
                             @RequestParam Long captainUserID) {
            try {
                adminRepository.assignCaptain(teamId, captainUserID);
                return "Captain assigned successfully.";
            } catch (Exception e) {
                return "Error assigning captain: " + e.getMessage();
            }
        }

        // Assign a referee to a game
        @PostMapping("/game/{gameId}/referee")
        String assignReferee(@PathVariable Long gameId, @RequestParam Long refereeUserId) {
            try {
                adminRepository.assignReferee(refereeUserId, gameId);
                return "Referee assigned successfully.";
            } catch (Exception e) {
                return "Error assigning referee: " + e.getMessage();
            }
        }

        // Update game score
        @PutMapping("/game/{gameId}/score")
        String updateGameScore(@PathVariable Long gameId,
                               @RequestParam int[] score) {
            try {
                adminRepository.updateGameScore(gameId, score);
                return "Game score updated successfully.";
            } catch (Exception e) {
                return "Error updating game score: " + e.getMessage();
            }
        }

        // Update game status
        @PutMapping("/game/{gameId}/status")
        String updateGameStatus(@PathVariable Long gameId,
                                @RequestParam String status) {
            try {
                adminRepository.updateGameStatus(gameId, status);
                return "Game status updated successfully.";
            } catch (Exception e) {
                return "Error updating game status: " + e.getMessage();
            }
        }
    }

