package com.footballmanager.service;

import com.footballmanager.dto.PlayerSummaryDTO;
import com.footballmanager.models.Player;
import com.footballmanager.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerSummaryDTO> getAllAsync() {
        return toDtos(playerRepository.findAll());
    }

    @Override
    public Optional<PlayerSummaryDTO> getByIdAsync(Long id) {
        return playerRepository.findById(id).map(this::toDto);
    }

    @Override
    public List<PlayerSummaryDTO> searchByNameAsync(String keyword) {
        return toDtos(playerRepository.findByNameContainingIgnoreCase(keyword));
    }

    @Override
    public List<PlayerSummaryDTO> getByPositionAsync(String position) {
        return toDtos(playerRepository.findByPosition(position));
    }

    @Override
    public List<PlayerSummaryDTO> getByTeamNameAsync(String teamName) {
        return toDtos(playerRepository.findByTeamName(teamName));
    }

    private List<PlayerSummaryDTO> toDtos(List<Player> players) {
        List<PlayerSummaryDTO> result = new ArrayList<>();
        for (Player player : players) {
            result.add(toDto(player));
        }
        return result;
    }

    private PlayerSummaryDTO toDto(Player player) {
        PlayerSummaryDTO dto = new PlayerSummaryDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setPosition(player.getPosition());
        dto.setPrice(player.getPrice());
        if (player.getTeam() != null) {
            dto.setTeamName(player.getTeam().getName());
        }
        return dto;
    }
}
