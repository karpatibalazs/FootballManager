package com.footballmanager.service;

import com.footballmanager.dto.TeamWithPlayersDTO;
import com.footballmanager.models.Team;
import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<Team> getAllAsync();
    Optional<TeamWithPlayersDTO> getByNameAsync(String name);
}