package com.thearqive.backend.repositories;

import com.thearqive.backend.entities.UserProfile;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    @Override
    List<UserProfile> findAll();

    UserProfile getUserProfileById(Long id);

    List<UserProfile> getUserProfileByRoleId(Long roleId);
}
