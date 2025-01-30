package com.example.users.service;

import org.springframework.stereotype.Service;

import com.example.users.model.UserProfile;
import com.example.users.repository.UserProfileRepository;

@Service
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    public UserProfile getUserProfile(Long userId) {
        return repository.findById(userId).orElse(null);
    }

    public UserProfile saveOrUpdateProfile(UserProfile profile) {
        return repository.save(profile);
    }
}
