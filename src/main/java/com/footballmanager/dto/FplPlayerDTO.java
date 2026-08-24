package com.footballmanager.dto;

public class FplPlayerDTO{
    private Long id;
    private String web_name;
    private Long team;
    private int element_type;
    private int now_cost;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getWeb_name() {return web_name;}
    public void setWeb_name(String web_name) {this.web_name = web_name;}
    public Long getTeam() {return team;}
    public void setTeam(Long team) {this.team = team;}
    public int getElement_type() {return element_type;}
    public void setElement_type(int element_type) {this.element_type = element_type;}
    public int getNow_cost() {return now_cost;}
    public void setNow_cost(int now_cost) {this.now_cost = now_cost;}
}