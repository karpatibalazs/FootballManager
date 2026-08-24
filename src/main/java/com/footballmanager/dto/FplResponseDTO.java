package com.footballmanager.dto;

import java.util.List;

public class FplResponseDTO {
    private List<FplTeamDTO> teams;
    private List<FplPlayerDTO> elements;

    public List<FplTeamDTO> getTeams() { return teams; }
    public void setTeams(List<FplTeamDTO> teams) { this.teams = teams; }
    public List<FplPlayerDTO> getElements() { return elements; }
    public void setElements(List<FplPlayerDTO> elements) { this.elements = elements; }
}