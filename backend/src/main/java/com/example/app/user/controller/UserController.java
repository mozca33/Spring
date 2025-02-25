package com.example.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.app.exception.ApiException;
import com.example.app.exception.ErrorResponse;
import com.example.app.user.dto.LoginRequestDTO;
import com.example.app.user.dto.RegisterRequestDTO;
import com.example.app.user.dto.UserDTO;
import com.example.app.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Autowired
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@RequestParam Long userId) {
        return ResponseEntity.ok(UserDTO.fromEntity(userService.getUserByID(userId)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequest) {
        try {
            userService.loginUser(loginRequest);
            return ResponseEntity.accepted().build();

        } catch (ApiException e) {
            return handleException(e);

        } catch (Exception e) {
            return handleException(e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDTO registerRequest) {
        try {
            userService.registerUser(registerRequest);

            return ResponseEntity.accepted().build();

        } catch (ApiException e) {
            return handleException(e);

        } catch (Exception e) {
            return handleException(e);
        }
    }

    private ResponseEntity<ErrorResponse> handleException(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(e.getMessage(),
                        e.getCause() != null ? e.getCause().toString() : "No cause found"));
    }

}
