package com.team5.ACMEFlix.transfer.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResourceViewingHistory extends BaseResource{
    @NotNull(message = "Profile's firstname cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z]*$", message="Profile's firstname can only contain alphabetical symbols")
    private String firstname;

    private String imageUrl;

    @NotNull(message = "Profile's age restriction cannot be null")
    @Column(nullable = false)
    private Boolean ageRestricted;

    private Float viewingHours;

    private List<ContentResourceViewingHistory> contents;
}
