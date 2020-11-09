package com.thearqive.backend.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private Long id;
    private String fullName;
    private String userName;
    private String bio;
    private Boolean profilePrivate;
    private String roleName;
}
