package com.thearqive.backend.dto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class RolesDto {
    private Long id;
    private String name;
    private List<UserProfileDto> userProfile = new ArrayList<>();

}
