package com.thearqive.backend.service;


import com.thearqive.backend.converter.Converter;
import com.thearqive.backend.dto.UserProfileDto;
import com.thearqive.backend.dto.UserProfileFormDto;
import com.thearqive.backend.entities.UserProfile;
import com.thearqive.backend.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    Converter converter;

    @Override
    public List<UserProfileDto> findAllUserProfiles() {
        return converter.userProfileListEntityToUserProfileDto(userProfileRepository.findAll());
    }

    @Override
    public UserProfileDto createUserProfile(UserProfileFormDto userProfileFormDto) {
        UserProfile userProfile = converter.userProfileDtoFormToEntity(userProfileFormDto);
        userProfile = userProfileRepository.save(userProfile);
        return converter.userProfileEntityToDto(userProfile);
    }

    @Override
    public UserProfileDto getUserProfileById(Long id) {
        return converter.userProfileEntityToDto(userProfileRepository.getUserProfileById(id));

    }

    @Override
    public Long deleteUserProfileById(Long id) {
        userProfileRepository.deleteById(id);
        return id;
    }
}
