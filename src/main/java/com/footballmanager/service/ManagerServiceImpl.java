package com.footballmanager.service;

import com.footballmanager.dto.CreateManagerDTO;
import com.footballmanager.dto.ManagerDTO;
import com.footballmanager.dto.PlayerSummaryDTO;
import com.footballmanager.models.FantasyTeam;
import com.footballmanager.models.Manager;
import com.footballmanager.models.Player;
import com.footballmanager.repositories.ManagerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public ManagerDTO createManager(CreateManagerDTO dto){
        if(managerRepository.existsByUsername(dto.getUsername())){
            throw new IllegalArgumentException("Username is already in use");
        }
        Manager manager = new Manager();
        manager.setUsername(dto.getUsername());
        manager.setBudget(dto.getBudget());
        Manager saved = managerRepository.save(manager);
        return toDto(saved);
    }

    @Override
    public Optional<ManagerDTO> getManagerById(Long id) {
        return managerRepository.findById(id).map(this::toDto);
    }

    @Override
    public ManagerDTO selectStartingTeam(Long managerId, String teamName) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private ManagerDTO toDto(Manager manager) {
        ManagerDTO dto = new ManagerDTO();
        dto.setId(manager.getId());
        dto.setUsername(manager.getUsername());
        dto.setBudget(manager.getBudget());
        dto.setPlayers(new ArrayList<>());

        FantasyTeam fantasyTeam = manager.getFantasyTeam();
        if (fantasyTeam != null) {
            if (fantasyTeam.getStartingTeam() != null) {
                dto.setStartingTeamName(fantasyTeam.getStartingTeam().getName());
            }
            List<PlayerSummaryDTO> players = new ArrayList<>();
            for (Player player : fantasyTeam.getPlayers()) {
                PlayerSummaryDTO p = new PlayerSummaryDTO();
                p.setId(player.getId());
                p.setName(player.getName());
                p.setPosition(player.getPosition());
                p.setPrice(player.getPrice());
                players.add(p);
            }
            dto.setPlayers(players);
        }
        return dto;
    }
}
