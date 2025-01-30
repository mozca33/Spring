package com.example.users.repository;

import org.springframework.stereotype.Repository;

import com.example.users.model.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{
}
