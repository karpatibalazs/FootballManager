package com.footballmanager.service;

import com.footballmanager.dto.TeamWithPlayersDTO;
import com.footballmanager.models.Team;

import com.footballmanager.dto.TeamSummaryDTO;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamSummaryDTO> getAllAsync();
    Optional<TeamWithPlayersDTO> getByNameAsync(String name);
}