package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
public class PaymentResource extends BaseResource {

    @NotNull(message = "Payment's amount cannot be null")
    @Column(nullable = false)
    private Float amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date paymentDate = new Date();

    @NotNull(message = "Payment subscription type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private SubscriptionType subscriptionType;


    private CreditCard creditCard;


    private Address address;

    private Account account;
}
