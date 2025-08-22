package utils;

import jakarta.persistence.Embeddable;

@Embeddable
public class PositiveInteger {

    int number;

    protected PositiveInteger() {
        // ORM
    }

    public PositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number should be positive");
        } else
            this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean isValid(int number) {
        return number > 0;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
