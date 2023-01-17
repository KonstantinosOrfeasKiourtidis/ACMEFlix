package com.team5.ACMEFlix.forms;

import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
public class SubscribeForm {
    @NotNull(message = "Subscription type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private SubscriptionType subscriptionType;

}
