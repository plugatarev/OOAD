package com.plugatarev.planninganddoing.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

    public UserDTO(@NotEmpty Long id, @NotEmpty String username, @NotEmpty String password, @NotEmpty String matchingPassword) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.matchingPassword = matchingPassword;
    }
}
