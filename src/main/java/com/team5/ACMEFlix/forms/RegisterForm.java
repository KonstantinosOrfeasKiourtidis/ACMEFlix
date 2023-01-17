package com.team5.ACMEFlix.forms;


import lombok.Getter;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Getter
public class RegisterForm {
    @NotNull(message = "Account's email cannot be null")
    @Column(length = 50, nullable = false, unique = true)
    @Email
    private String email;
    @NotNull(message = "Account's username cannot be null")
    @Column(length = 50, nullable = false, unique = false)
    @Pattern(regexp = "^[A-Za-z0-9]*$", message="Account's username can only contain alphanumeric symbols")
    private String username;
    @NotNull(message = "Account's firstname cannot be null")
    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message="Account's firstname can only contain alphabetical symbols")
    private String firstname;
    @NotNull(message = "Account's lastname cannot be null")
    @Column(length = 30, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message="Account's lastname can only contain alphabetical symbols")
    private String lastname;
    @NotNull(message = "Account's password cannot be null")
    @Column(length = 50, nullable = false)
    private String password;
    @NotNull(message = "Account's password cannot be null")
    @Column(length = 50, nullable = false)
    private String confirmPassword;
    @Column(length = 14)
    @Pattern(regexp = "^[0-9]*$", message="Account's phone Number can only contain numeric symbols")
    private String phoneNo;


}
