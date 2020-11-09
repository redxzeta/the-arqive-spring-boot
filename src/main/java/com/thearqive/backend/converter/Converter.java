package com.thearqive.backend.converter;

import com.thearqive.backend.dto.RolesDto;
import com.thearqive.backend.dto.RolesDtoForm;
import com.thearqive.backend.dto.UserProfileDto;
import com.thearqive.backend.dto.UserProfileFormDto;
import com.thearqive.backend.entities.Roles;
import com.thearqive.backend.entities.UserProfile;
import com.thearqive.backend.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {
    @Autowired
    RolesRepository rolesRepository;

    public RolesDto rolesEntityToRolesDto(Roles roles) {
        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(roles.getId());
        rolesDto.setName(roles.getName());
        rolesDto.setUserProfile(userProfileListEntityToUserProfileDto(roles.getUserProfile()));
        return rolesDto;
    }

    public List<RolesDto> rolesListEntityToRolesDto(List<Roles> roles) {
        return roles.stream().map(role -> rolesEntityToRolesDto(role)).collect(Collectors.toList());
    }

    public Roles roleDtoFormToEntity(RolesDtoForm rolesDtoForm) {
        List<UserProfile> emptyList = Collections.emptyList();
        Roles roles = new Roles();
        roles.setName(rolesDtoForm.getName());
        roles.setUserProfile(emptyList);
        return roles;
    }

    public UserProfileDto userProfileEntityToDto(UserProfile userProfile) {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setId(userProfile.getId());
        userProfileDto.setFullName(userProfile.getFirstName() + " " + userProfile.getLastName());
        userProfileDto.setBio(userProfile.getBio());
        userProfileDto.setProfilePrivate(userProfile.getProfilePrivate());
        userProfileDto.setRoleName(userProfile.getRole().getName());
        return userProfileDto;
    }

    public List<UserProfileDto> userProfileListEntityToUserProfileDto(List<UserProfile> userProfiles) {
        return userProfiles.stream().map(userProfile -> userProfileEntityToDto(userProfile)).collect(Collectors.toList());

    }

    public UserProfile userProfileDtoFormToEntity(UserProfileFormDto userProfileFormDto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(userProfileFormDto.getFirstName());
        userProfile.setLastName(userProfileFormDto.getLastName());
        userProfile.setUserName(userProfileFormDto.getUserName());
        userProfile.setBio(userProfileFormDto.getBio());
        userProfile.setProfilePrivate(userProfileFormDto.getProfilePrivate());
        userProfile.setRole(rolesRepository.getById(userProfileFormDto.getRole()));
        return userProfile;
    }
}
