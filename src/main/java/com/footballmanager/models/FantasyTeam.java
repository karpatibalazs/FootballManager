package com.footballmanager.models;

import java.util.List;

import com.footballmanager.models.Player;

import jakarta.persistence.*;
@Entity
public class FantasyTeam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team startingTeam;

    @ManyToMany
    @JoinTable(
        name = "fantasy_team_players",
        joinColumns = @JoinColumn(name = "fantasy_team_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }

    public Team getStartingTeam() { return startingTeam; }
    public void setStartingTeam(Team startingTeam) { this.startingTeam = startingTeam; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
}
