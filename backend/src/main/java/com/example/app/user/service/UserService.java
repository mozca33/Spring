package com.example.app.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import com.example.app.user.model.User;
import com.example.app.user.repository.UserRepository;
import com.example.app.utils.ValidationMessages;
import com.example.app.exception.ApiException;
import com.example.app.user.dto.LoginRequestDTO;
import com.example.app.user.dto.RegisterRequestDTO;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByID(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
    }

    public void loginUser(LoginRequestDTO loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ApiException(ValidationMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ApiException(ValidationMessages.INVALID_CREDENTIALS, HttpStatus.UNAUTHORIZED);
        }
    }

    public void registerUser(@Valid RegisterRequestDTO registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new ApiException(ValidationMessages.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
        }
        User user = new User(
                registerRequest.getName(),
                registerRequest.getEmail(),
                registerRequest.getBirthDate(),
                passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);
    }
}
