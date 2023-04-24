package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    @DisplayName("로또는 1~45의 숫자이다.")
    void validateBound() {
        // given
        Number number = new Number();
        // when
        boolean actual = number.validateBound(45);
        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("로또는 1~45의 숫자이다.")
    void validateBound1() {
        // given
        Number number = new Number();
        // when
        boolean actual = number.validateBound(46);
        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("로또는 1~45의 숫자이다.")
    void validateBound2() {
        // given
        Number number = new Number();
        // when
        boolean actual = number.validateBound(1);
        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("로또는 1~45의 숫자이다.")
    void validateBound3() {
        // given
        Number number = new Number();
        // when
        boolean actual = number.validateBound(0);
        // then
        assertThat(actual).isFalse();
    }

}