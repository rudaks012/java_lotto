package domain;

import java.util.Objects;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private int number = 0;

    public Number(int number) {
        if (validateBound(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateBound(int value) {
        return value <= MAX && value >= MIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
