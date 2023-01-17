package com.team5.ACMEFlix.transfer.resource;


import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString(callSuper = true)
public class AddressResource extends BaseResource {
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


}
