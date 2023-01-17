package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.domain.enumeration.CardType;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString(callSuper = true)
public class CreditCardResource2 extends BaseResource {
    @NotNull(message = "Credit card number cannot be null")
    @Column(length = 16, nullable = false)
    @Pattern(regexp = "^[0-9]*$", message="Credit cards's number can only contain numeric symbols")
    private String cardNo;

    @NotNull(message = "Credit card name cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z\\. ]+$", message="Credit card's name can only contain alphabetical symbols")
    private String cardName;


    @NotNull(message = "Credit card expiration cannot be null")
    @Column(length = 30, nullable = false)
    private String cardExpirationDate;

    @NotNull(message = "Credit card type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CardType cardType;

}
