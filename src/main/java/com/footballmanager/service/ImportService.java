package com.footballmanager.service;

import com.footballmanager.dto.FplResponseDTO;
import com.footballmanager.dto.FplTeamDTO;
import com.footballmanager.dto.FplPlayerDTO;
import com.footballmanager.models.Team;
import com.footballmanager.models.Player;
import com.footballmanager.repositories.TeamRepository;
import com.footballmanager.repositories.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class ImportService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final RestClient restClient = RestClient.create();

    public ImportService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public String importData() {
    System.out.println("1. Kérés indul az FPL API-hoz...");
    FplResponseDTO response = restClient.get()
            .uri("https://fantasy.premierleague.com/api/bootstrap-static/")
            .retrieve()
            .body(FplResponseDTO.class);
    System.out.println("2. Válasz megérkezett! Csapatok: " + response.getTeams().size() + ", Játékosok: " + response.getElements().size());

    Map<Long, Team> teamMap = new HashMap<>();

    for (FplTeamDTO teamDto : response.getTeams()) {
        Team team = new Team();
        team.setExternalId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setShortName(teamDto.getShort_name());
        Team saved = teamRepository.save(team);
        teamMap.put(teamDto.getId(), saved);
    }
    System.out.println("3. Csapatok elmentve: " + teamMap.size());

    List<Player> players = new ArrayList<>();
    for (FplPlayerDTO playerDto : response.getElements()) {
        Player player = new Player();
        player.setExternalId(playerDto.getId());
        player.setName(playerDto.getWeb_name());
        player.setPosition(mapPosition(playerDto.getElement_type()));
        player.setPrice(playerDto.getNow_cost() / 10.0);
        player.setTeam(teamMap.get(playerDto.getTeam()));
        players.add(player);
    }
    System.out.println("4. Játékos lista összeállítva: " + players.size());

    playerRepository.saveAll(players);
    System.out.println("5. Játékosok elmentve!");

    return "Import kész! " + response.getTeams().size() + " csapat, " + response.getElements().size() + " játékos.";
}

    private String mapPosition(int elementType) {
        return switch (elementType) {
            case 1 -> "GOALKEEPER";
            case 2 -> "DEFENDER";
            case 3 -> "MIDFIELDER";
            case 4 -> "FORWARD";
            default -> "UNKNOWN";
        };
    }
}