package domain;

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
}
