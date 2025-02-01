package com.example.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.validator.ValidationMessages;
import com.example.exception.ApiException;
import com.example.user.dto.UserDTO;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public UserDTO getUserInfo(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        UserDTO response = new UserDTO();
        response.setId(user.getId());
        response.setDescription(user.getDescription());
        response.setName(user.getName());
        response.setProfileImageUrl(user.getProfileImageUrl());

        return response;
    }

    public User registerUser(@Valid @RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent() ||
            userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new ApiException(HttpStatus.BAD_REQUEST, ValidationMessages.USER_ALREADY_EXISTS);
        }
        return userRepository.save(user);
    }
}
