package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PROFILES", indexes = {@Index(columnList = "firstname")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PROFILES_SEQ", initialValue = 1, allocationSize = 1)
public class Profile extends BaseModel{

    @NotNull(message = "Profile's firstname cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z]*$", message="Profile's firstname can only contain alphabetical symbols")
    private String firstname;

    private String imageUrl;

    @NotNull(message = "Profile's age restriction cannot be null")
    @Column(nullable = false)
    private Boolean ageRestricted;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Account.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="account_id")
    private Account account;


}
