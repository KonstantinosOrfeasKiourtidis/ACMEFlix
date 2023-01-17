package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ADDRESSES", indexes = {@Index(columnList = "streetName")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ADDRESSES_SEQ", initialValue = 1, allocationSize = 1)
public class Address extends BaseModel{

    @NotNull(message = "Address's street name cannot be null")
    @Column(length = 50, nullable = false)
    @Pattern(regexp = "^[A-Za-z\\. ]+$", message="Address's street name can only contain alphabetical symbols")
    private String streetName;

    @NotNull(message = "Address's street number cannot be null")
    @Column(length = 50, nullable = false)
    @Pattern(regexp = "^[0-9]*$", message="Address's street number can only contain numeric symbols")
    @Min(0)
    private String streetNo;

    @NotNull(message = "Address's postal code cannot be null")
    @Column(length = 6, nullable = false)
    @Pattern(regexp = "^[0-9]*$", message="Address's postal code can only contain numeric symbols")
    private String postalCode;

    @NotNull(message = "Address's country cannot be null")
    @Column(length = 50, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message="Address's country can only contain alphabetical symbols")
    private String country;

    @NotNull(message = "Address's province cannot be null")
    @Column(length = 50, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message="Address's province can only contain alphabetical symbols")
    private String province;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Account.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="account_id")
    private Account account;
}
