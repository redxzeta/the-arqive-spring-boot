package com.thearqive.backend.controllers;

import com.thearqive.backend.dto.UserProfileDto;
import com.thearqive.backend.dto.UserProfileFormDto;
import com.thearqive.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping
    public List<UserProfileDto> getAllUsers() {
        return userProfileService.findAllUserProfiles();
    }

    @PostMapping
    public UserProfileDto createUserProfile(@RequestBody UserProfileFormDto userProfileFormDto){
        return userProfileService.createUserProfile(userProfileFormDto);
    }
    @GetMapping("/{id}")
    public UserProfileDto getUserProfileById(@PathVariable Long id){
        return userProfileService.getUserProfileById(id);
    }
}
