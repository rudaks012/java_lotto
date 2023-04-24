package domain;

public class Number {

    private static final int MAX = 45;
    private static final int MIN = 1;

    public boolean validateBound(int value) {
        return value <= MAX && value >= MIN;
    }
}
