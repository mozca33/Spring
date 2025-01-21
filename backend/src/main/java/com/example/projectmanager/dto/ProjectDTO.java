package com.example.projectmanager.dto;

public class ProjectDTO {
    private String name;
    private String description;

    public ProjectDTO(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
