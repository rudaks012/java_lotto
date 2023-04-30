package domain;

public class LottoNumber {
    private final int value;

    public LottoNumber(int value) {
        validation(value);
        this.value = value;
    }

    private static void validation(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
