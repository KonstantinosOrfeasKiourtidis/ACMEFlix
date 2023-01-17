package com.team5.ACMEFlix.forms;

import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
public class LoginForm {
    @NotNull(message = "Account's email cannot be null")
    @Column(length = 50, nullable = false, unique = true)
    @Email
    private String email;
    @NotNull(message = "Account's password cannot be null")
    @Column(length = 50, nullable = false)
    private String password;


}
