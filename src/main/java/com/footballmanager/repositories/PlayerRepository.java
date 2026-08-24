package com.footballmanager.repositories;

import com.footballmanager.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    List<Player> findByNameContainingIgnoreCase(String keyword);
    List<Player> findByPosition(String position);
    List<Player> findByTeamName(String teamName);
}