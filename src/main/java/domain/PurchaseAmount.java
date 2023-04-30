package domain;

public class PurchaseAmount {

    public static final int PRICE = 1000;
    private final int value;

    public PurchaseAmount(int value) {
        validation(value);
        this.value = value;
    }

    private void validation(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 작을 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public int calculateLottoTicketCount() {
        return value / PRICE;
    }
}
