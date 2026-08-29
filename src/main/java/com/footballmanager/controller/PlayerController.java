package com.footballmanager.controller;

import com.footballmanager.dto.PlayerSummaryDTO;
import com.footballmanager.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerSummaryDTO> getAll() {
        return playerService.getAllAsync();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerSummaryDTO> getById(@PathVariable Long id) {
        return playerService.getByIdAsync(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<PlayerSummaryDTO> search(@RequestParam String name) {
        return playerService.searchByNameAsync(name);
    }

    @GetMapping("/position/{position}")
    public List<PlayerSummaryDTO> getByPosition(@PathVariable String position) {
        return playerService.getByPositionAsync(position);
    }

    @GetMapping("/team/{teamName}")
    public List<PlayerSummaryDTO> getByTeamName(@PathVariable String teamName) {
        return playerService.getByTeamNameAsync(teamName);
    }
}
