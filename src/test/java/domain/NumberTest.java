package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("로또는 1~45의 숫자이다.")
    void validateBound() {
        // given
        Number number = new Number(45);
        // when
        // then
        assertThat(number).isNotNull();
    }

    @Test
    @DisplayName("로또는 1~45의 숫자이다.")
    void validateBound1() {
        assertThatThrownBy(() -> new Number(46))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 비교")
    void compare() {
        // given

        // when

        // then
        assertThat(new Number(1)).isEqualTo(new Number(1));
    }
}