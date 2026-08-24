package com.footballmanager.dto;

public class TeamWithPlayersDTO{
    private String name;
    private String shortName;
    private List<PlayerSummaryDTO> players;
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getShortName() {return shortName;}
    public void setShortName(String shortName) {this.shortName = shortName;}
    public List<PlayerSummaryDTO> getPlayers() {return players;}
    public void setPlayers(List<PlayerSummaryDTO> players) {this.players = players;}
}