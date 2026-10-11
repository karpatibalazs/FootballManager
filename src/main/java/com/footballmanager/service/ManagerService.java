package com.footballmanager.service;

import com.footballmanager.dto.CreateManagerDTO;
import com.footballmanager.dto.ManagerDTO;
import java.util.Optional;

public interface ManagerService {
    ManagerDTO createManager(CreateManagerDTO dto);
    Optional<ManagerDTO> getManagerById(Long id);
    ManagerDTO selectStartingTeam(Long managerId, String teamName);
}