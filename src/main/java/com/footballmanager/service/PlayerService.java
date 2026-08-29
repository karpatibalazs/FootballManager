package com.footballmanager.service;

import com.footballmanager.dto.PlayerSummaryDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerSummaryDTO> getAllAsync();
    Optional<PlayerSummaryDTO> getByIdAsync(Long id);
    List<PlayerSummaryDTO> searchByNameAsync(String keyword);
    List<PlayerSummaryDTO> getByPositionAsync(String position);
    List<PlayerSummaryDTO> getByTeamNameAsync(String teamName);
}
