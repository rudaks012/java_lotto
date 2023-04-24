package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    @DisplayName("구매 가능한 로또의 개수를 알려준다.")
    void informLottoCount() {
        // given
        Amount amount = new Amount();
        int payAmount = 14500;
        // when
        int actual =  amount.informLottoCount(payAmount);
        // then
        Assertions.assertThat(actual).isEqualTo(14);

    }

}