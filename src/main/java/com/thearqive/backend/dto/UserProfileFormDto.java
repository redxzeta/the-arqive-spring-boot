package com.thearqive.backend.dto;

import lombok.Data;

@Data
public class UserProfileFormDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String bio;
    private Boolean profilePrivate;
    private Long role;
}
