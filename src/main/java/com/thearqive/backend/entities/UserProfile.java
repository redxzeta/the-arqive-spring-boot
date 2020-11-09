package com.thearqive.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class UserProfile {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String bio;
    private Boolean profilePrivate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Roles role;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Pins> pins = new ArrayList<>();


}
