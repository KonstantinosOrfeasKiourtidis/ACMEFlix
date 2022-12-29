package com.team5.ACMEFlix.domain;

import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PAYMENTS", indexes = {@Index(columnList = "amount")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PAYMENTS_SEQ", initialValue = 1, allocationSize = 1)
public class Payment extends BaseModel{

    @NotNull(message = "Payment's amount cannot be null")
    @Column(nullable = false)
    private float amount;

//    @NotNull(message = "Payment's date cannot be null")
//    @Column(nullable = false)
    private Date paymentDate;

    @NotNull(message = "Payment subscription type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private SubscriptionType subscriptionType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "creditCard_id", referencedColumnName = "id")
    private CreditCard creditCard;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
}
