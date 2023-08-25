package org.example.enums;


public enum Gender {
    MALE(true),
    FEMALE(false);

    private final Boolean value;

    Gender(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }
}
