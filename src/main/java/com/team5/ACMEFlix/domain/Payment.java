package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Float amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date paymentDate = new Date();

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
