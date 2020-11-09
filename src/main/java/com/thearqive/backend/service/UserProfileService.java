package com.thearqive.backend.service;


import com.thearqive.backend.dto.UserProfileDto;
import com.thearqive.backend.dto.UserProfileFormDto;

import java.util.List;

public interface UserProfileService {

    List<UserProfileDto> findAllUserProfiles();

    UserProfileDto createUserProfile(UserProfileFormDto userProfileFormDto);

    UserProfileDto getUserProfileById(Long id);

    Long deleteUserProfileById(Long id);

    List<UserProfileDto> getAllUserProfilesByRole(Long roleId);
}
