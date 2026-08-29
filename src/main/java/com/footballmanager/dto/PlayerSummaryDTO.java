package com.footballmanager.dto;

public class PlayerSummaryDTO {
    private Long id;
    private String name;
    private String position;
    private double price;
    private String teamName;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public String getTeamName() {return teamName;}
    public void setTeamName(String teamName) {this.teamName = teamName;}
}