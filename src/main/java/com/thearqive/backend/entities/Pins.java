package com.thearqive.backend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Pins {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private UserProfile userProfile;
    private String title;
    private String description;
    private Float latitude;
    private Float longitude;
    private LocalDateTime createdAt = LocalDateTime.now();

    //category




}
