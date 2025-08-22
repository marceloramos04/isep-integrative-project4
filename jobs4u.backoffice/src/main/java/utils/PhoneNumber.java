package utils;

import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {

    private String number;

    public PhoneNumber(String number) {

        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Phone number should neither be null nor empty");
        }

        if (!isValidPhoneNumber(number)) {
            throw new IllegalArgumentException("Phone number should contain exactly 9 digits and only numbers");
        }

        this.number = number;
    }

    protected PhoneNumber() {
        // Default constructor for JPA
    }

    private boolean isValidPhoneNumber(String number) {
        return number.matches("\\d{9}");
    }

    @Override
    public String toString() {
        return number;
    }
}
