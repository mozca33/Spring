package com.example.home;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import com.example.home.service.HomeServiceImpl;
import com.example.users.model.UserProfile;
import com.example.users.service.UserProfileService;

@RunWith(MockitoJUnitRunner.class)
public class HomeServiceImplTest {
    @InjectMocks
    private HomeServiceImpl homeService;

    @Mock
    private UserProfileService userProfileService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserProfile() {
        Long userId = 1L;
        UserProfile expectedProfile = new UserProfile();
        expectedProfile.setId(userId);
        when(userProfileService.getUserProfile(userId)).thenReturn(expectedProfile);

        UserProfile result = homeService.getUserProfile(userId);

        assertEquals(expectedProfile, result);
    }

    @Test
    void testSaveOrUpdateUserProfile() {
        UserProfile profile = new UserProfile();
        profile.setName("Jane Doe");

        when(userProfileService.saveOrUpdateProfile(profile)).thenReturn(profile);

        UserProfile result = homeService.saveOrUpdateUserProfile(profile);

        assertEquals(profile, result);
    }
}