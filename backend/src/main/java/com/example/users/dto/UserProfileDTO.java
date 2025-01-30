package com.example.users.dto;

public class UserProfileDTO {

    private Long id;
    private String name;
    private String about;
    private String profileImageUrl;

    public UserProfileDTO(String name, String about, String profileImageUrl) {
        this.name = name;
        this.about = about;
        this.profileImageUrl = profileImageUrl;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }
}
