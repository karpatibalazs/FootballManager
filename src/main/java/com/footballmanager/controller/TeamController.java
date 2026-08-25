package com.footballmanager.controller;

import com.footballmanager.service.TeamService;

import com.footballmanager.dto.TeamSummaryDTO;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import com.footballmanager.models.Team;
import com.footballmanager.dto.TeamWithPlayersDTO;
import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController{

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamSummaryDTO> getAll() {
        return teamService.getAllAsync();
    }

    @GetMapping("/{name}")
    public ResponseEntity<TeamWithPlayersDTO> getByName(@PathVariable String name) {
        return teamService.getByNameAsync(name)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
}