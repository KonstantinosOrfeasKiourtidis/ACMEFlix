package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ACCOUNTS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel{
    @NotNull(message = "Account's email cannot be null")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotNull(message = "Account's username cannot be null")
    @Column(length = 50, nullable = false, unique = false)
    private String username;

    @NotNull(message = "Account's firstname cannot be null")
    @Column(length = 20, nullable = false)
    private String firstname;

    @NotNull(message = "Account's lastname cannot be null")
    @Column(length = 30, nullable = false)
    private String lastname;

    @NotNull(message = "Account's password cannot be null")
    @Column(length = 50, nullable = false)
    private String password;

    private String phoneNo;

    @NotNull(message = "Subscription type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private SubscriptionType subscriptionType;

    private Date creationDate;
    private Date subscriptionDate;

    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Address.class, fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address;

    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=CreditCard.class, fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditCard> creditCards;

    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Profile.class, fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> profiles;


}
