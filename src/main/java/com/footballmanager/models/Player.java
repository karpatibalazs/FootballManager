package com.footballmanager.models;

import jakarta.persistence.*;

@Entity
public class Player{

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long externalId;
    private String name;
    private String position;
    private double price;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getExternalId() { return externalId; }
    public void setExternalId(Long externalId) { this.externalId = externalId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}