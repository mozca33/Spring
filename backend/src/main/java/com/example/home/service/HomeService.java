package com.example.home.service;

import com.example.users.model.UserProfile;

public interface HomeService {
    UserProfile saveOrUpdateUserProfile(UserProfile profile);
    UserProfile saveOrUpdateUserProfile();
    UserProfile getUserProfile(Long userId);
}