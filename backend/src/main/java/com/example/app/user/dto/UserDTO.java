package com.example.app.user.dto;

import com.example.app.user.model.User;

public record UserDTO(Long id, String name, String email) {
    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }
}
