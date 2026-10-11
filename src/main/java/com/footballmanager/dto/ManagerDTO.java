package com.footballmanager.dto;

import java.util.List;

public class ManagerDTO{
    private Long id;
    private String username;
    private double budget;
    private String startingTeamName;
    private List<PlayerSummaryDTO> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlayerSummaryDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerSummaryDTO> players) {
        this.players = players;
    }

    public String getStartingTeamName() {
        return startingTeamName;
    }

    public void setStartingTeamName(String startingTeamName) {
        this.startingTeamName = startingTeamName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
