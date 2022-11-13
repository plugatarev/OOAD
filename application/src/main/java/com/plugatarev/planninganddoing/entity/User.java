package com.plugatarev.planninganddoing.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User() {}

    public User(@NotEmpty Long id, @NotEmpty String username, @NotEmpty String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
