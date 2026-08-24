package com.footballmanager.service;

import com.footballmanager.dto.TeamWithPlayersDTO;
import com.footballmanager.models.Team;
import java.util.List;
import java.util.Optional;

public class TeamServiceImpl implements TeamService {
    List<Team> getAllAsync();
    @override
    public Optional<TeamWithPlayersDTO> getByNameAsync(String name) {
    Optional<Team> teamOpt = teamRepository.findByName(name);
    if (teamOpt.isEmpty()) {
        return Optional.empty();
    }
    
    Team team = teamOpt.get();
    
    List<PlayerSummaryDTO> playerDtos = new ArrayList<>();
    for (Player player : team.getPlayers()) {
        PlayerSummaryDTO dto = new PlayerSummaryDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setPosition(player.getPosition());
        dto.setPrice(player.getPrice());
        playerDtos.add(dto);
    }
    
    TeamWithPlayersDTO result = new TeamWithPlayersDTO();
    result.setName(team.getName());
    result.setShortName(team.getShortName());
    result.setPlayers(playerDtos);
    
    return Optional.of(result);
}
}