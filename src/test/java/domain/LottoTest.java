package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또는 6개의 숫자로 생성된다.")
    void createLottoNumber2() {
        // given
        Lotto lotto = new Lotto();
        // when
        List<Number> lottoList = lotto.createLottoNumber();
        int actual = lottoList.size();
        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("로또는 중복되지 않은 6개의 숫자로 구성되어 있다")
    void 로또는_중복되지_않은_6개의_숫자로_구성되어_있다2() {
        // given
        Lotto lotto = new Lotto();
        List<Number> lottoNumber = lotto.createLottoNumber();
        // when
        int actual = new HashSet<>(lottoNumber).size();
        // then
        assertThat(actual).isEqualTo(6);
    }
    
    @Test
    @DisplayName("로또는 6개의 숫자로 생성된다.")
    void createLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.size()).isEqualTo(6);
    }
}
