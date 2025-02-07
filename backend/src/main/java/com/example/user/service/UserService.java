package com.example.user.service;

import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.validator.ValidationMessages;
import com.example.exception.ApiException;
import com.example.user.dto.UserDTO;

@Service
public class UserService {

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

    public UserDTO loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ValidationMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!user.getPassword().equals(password)) {
            throw new ApiException(ValidationMessages.INVALID_CREDENTIALS, HttpStatus.UNAUTHORIZED);
        }

        UserDTO response = new UserDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }

    public UserDTO registerUser(@Valid User user) {
        UserDTO userDTO = new UserDTO();
        try {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new ApiException(ValidationMessages.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
            }

            userDTO = userRepository.save(user).toUserDTO();
            userDTO.setSuccess(true);

        } catch (Exception e) {
            userDTO.setSuccess(false);
        }

        return userDTO;
    }
}
