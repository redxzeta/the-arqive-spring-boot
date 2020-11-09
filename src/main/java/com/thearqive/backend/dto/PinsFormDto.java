package com.thearqive.backend.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PinsFormDto {
    private Long userProfileId;
    private String title;
    private String description;
    private Float latitude;
    private Float longitude;
    private LocalDateTime createdAt = LocalDateTime.now();
}
