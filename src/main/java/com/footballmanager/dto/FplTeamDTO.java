package com.footballmanager.dto;

public class FplTeamDTO {
    private Long id;
    private String name;
    private String short_name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getShort_name() { return short_name; }
    public void setShort_name(String short_name) { this.short_name = short_name; }
}