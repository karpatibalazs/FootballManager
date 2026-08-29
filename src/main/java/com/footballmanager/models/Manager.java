package com.footballmanager.models;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private double budget;
    
    @OneToOne
    @JoinColumn(name = "fantasy_team_id")
    private FantasyTeam fantasyTeam;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
 
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
 
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
 
    public FantasyTeam getFantasyTeam() { return fantasyTeam; }
    public void setFantasyTeam(FantasyTeam fantasyTeam) { this.fantasyTeam = fantasyTeam; }

}
