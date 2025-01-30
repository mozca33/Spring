package com.example.home.service;

import com.example.users.model.UserProfile;
import com.example.users.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    private UserProfileService userService; 

    public HomeServiceImpl(UserProfileService userService){
        this.userService = userService;
    }

    @Override
    public UserProfile getUserProfile(Long userId) {
        return userService.getUserProfile(userId);
    }

    @Override
    public UserProfile saveOrUpdateUserProfile(UserProfile profile) {
        return userService.saveOrUpdateProfile(profile);
    }

    @Override
    public UserProfile saveOrUpdateUserProfile() {
        UserProfile profile = new UserProfile();
        profile.setName("John Doe");
        profile.setDescription("Sou um desenvolvedor fullstack bla bla bla");

        return userService.saveOrUpdateProfile(profile);
    }
}
