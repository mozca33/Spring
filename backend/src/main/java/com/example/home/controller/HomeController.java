package com.example.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.home.service.HomeService;
import com.example.users.model.UserProfile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService service;

    public HomeController(HomeService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public UserProfile getHomeData(@PathVariable Long userId) {
        return service.getUserProfile(userId);
    }

    @PostMapping("/profile")
    public UserProfile createOrUpdateProfile(@RequestBody UserProfile profile) {
        return service.saveOrUpdateUserProfile(profile);
    }
    
}
