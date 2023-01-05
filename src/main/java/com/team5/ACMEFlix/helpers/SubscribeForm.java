package com.team5.ACMEFlix.helpers;

import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;

public class SubscribeForm {
    private SubscriptionType subscriptionType;

    public SubscribeForm() {
    }

    public SubscribeForm(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
