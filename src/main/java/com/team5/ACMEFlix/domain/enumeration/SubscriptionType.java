package com.team5.ACMEFlix.domain.enumeration;

public enum SubscriptionType {
    NO_SUBSCRIPTION(0.00f, 0), BASIC(7.99f, 2), STANDARD(10.99f, 3), PREMIUM(13.99f, 4);

    private final float price;

    private final int maxNoOfProfiles;

    SubscriptionType(float price, int maxNoOfProfiles) {

        this.price = price;
        this.maxNoOfProfiles =maxNoOfProfiles;
    }

    public float getPrice() {
        return price;
    }
    public int getMaxNoOfProfiles() {
        return maxNoOfProfiles;
    }
}
