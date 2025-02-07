package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

import com.example.user.model.User;
import com.example.exception.ApiException;
import com.example.exception.ErrorResponse;
import com.example.user.dto.LoginRequestDTO;
import com.example.user.dto.RegisterRequestDTO;
import com.example.user.dto.UserDTO;
import com.example.user.service.UserService;
import com.example.validator.ValidationMessages;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/info")
    public UserDTO getUserInfo(@RequestParam Long userId) {
        return userService.getUserInfo(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequest) {
        try {
            UserDTO user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(user);
        } catch (ApiException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(
                            e.getMessage(),
                            e.getCause() != null ? e.getCause().toString() : "No cause found."));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                    .body(new ErrorResponse(
                            e.getMessage(),
                            e.getCause() != null ? e.getCause().toString() : "No cause found."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequestDTO registerRequest) {
        try {
            User user = new User(
                    registerRequest.getName(),
                    registerRequest.getEmail(),
                    registerRequest.getBirthDate(),
                    registerRequest.getPassword());

            UserDTO userDTO = userService.registerUser(user);

            if (userDTO.getSuccess()) {
                return ResponseEntity.ok(HttpStatus.CREATED);
            }

            throw new ApiException(ValidationMessages.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);

        } catch (ApiException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(
                            e.getMessage(),
                            e.getCause() != null ? e.getCause().toString() : "No cause found."));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(
                            e.getMessage(),
                            e.getCause() != null ? e.getCause().toString() : "No cause found."));
        }
    }

}
