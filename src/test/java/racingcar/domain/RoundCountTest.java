package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundCountTest {
    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다")
    void 생성시_숫자_유효성검사() {
        // given
        String count = "a";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RoundCount(count));
    }
}
