package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.team5.ACMEFlix.domain.enumeration.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@Table(name = "CREDIT_CARDS", indexes = {@Index(columnList = "cardNo")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CREDIT_CARDS_SEQ", initialValue = 1, allocationSize = 1)
public class CreditCard extends BaseModel{

    @NotNull(message = "Credit card number cannot be null")
    @Column(length = 16, nullable = false)
    @Pattern(regexp = "^[0-9]*$", message="Credit cards's number can only contain numeric symbols")
    private String cardNo;

    @NotNull(message = "Credit card name cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z\\. ]+$", message="Credit card's name can only contain alphabetical symbols")
    private String cardName;

    @NotNull(message = "Credit card cvc cannot be null")
    @Column(length = 3, nullable = false)
    @Pattern(regexp = "^[0-9]*$", message="Credit cvc can only contain numeric symbols")
    private String cardCvc;

    @NotNull(message = "Credit card expiration cannot be null")
    @Column(length = 30, nullable = false)
    private String cardExpirationDate;

    @NotNull(message = "Credit card type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CardType cardType;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Account.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="account_id")
    private Account account;
}
