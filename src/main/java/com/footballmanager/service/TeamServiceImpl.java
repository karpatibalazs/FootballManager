package com.footballmanager.service;

import com.footballmanager.dto.TeamWithPlayersDTO;
import com.footballmanager.models.Team;

import com.footballmanager.repositories.TeamRepository;

import java.util.List;
import java.util.Optional;

import com.footballmanager.dto.PlayerSummaryDTO;
import java.util.ArrayList;
import com.footballmanager.models.Player;
import org.springframework.stereotype.Service;
import com.footballmanager.dto.TeamSummaryDTO;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public List<TeamSummaryDTO> getAllAsync() {
        List<TeamSummaryDTO> result = new ArrayList<>();
        for (Team team : teamRepository.findAll()) {
            TeamSummaryDTO dto = new TeamSummaryDTO();
            dto.setId(team.getId());
            dto.setName(team.getName());
            dto.setShortName(team.getShortName());
            result.add(dto);
        }
        return result;
    }
    @Override
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