package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또는 6개의 숫자로 생성된다.")
    void createLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.size()).isEqualTo(6);
    }
}
