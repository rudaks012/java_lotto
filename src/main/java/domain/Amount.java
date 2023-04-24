package domain;

public class Amount {

    private static final int LOTTO_ONE_AMOUNT = 1000;

    public int informLottoCount(int payAmount) {
        return payAmount / LOTTO_ONE_AMOUNT;
    }
}
