package com.footballmanager.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Team{

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long externalId;
    private String name;
    private String shortName;

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getExternalId() { return externalId; }
    public void setExternalId(Long externalId) { this.externalId = externalId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getShortName() { return shortName; }
    public void setShortName(String shortName) { this.shortName = shortName; }

}
