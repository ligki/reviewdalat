package com.ligki.reviewdalat.constant;

public enum ReviewObjectType {
    PLACE("place", "1"),
    COFFEE_SHOP("coffee-shop", "2"),
    HOTEL("hotel", "3"),
    FOOD("food", "4");

    private final String key;
    private final String value;

    ReviewObjectType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
