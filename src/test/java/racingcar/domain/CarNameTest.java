package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    @DisplayName("각 자동차의 이름의 길이가 5자를 초과할 경우 예외가 발생한다.")
    void 생성시_길이_유효성검사() {
        // given
        String name = "abcdef";

        // when & then 
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(name));
    }
}
