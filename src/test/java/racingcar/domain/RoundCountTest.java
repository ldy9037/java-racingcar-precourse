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
                .isThrownBy(() -> new RoundCount(count))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(ErrorMessage.NOT_DIGIT_ERROR.getMessage());
    }

    @Test
    @DisplayName("음수를 입력하면 예외가 발생한다")
    void 생성시_음수_유효성검사() {
        // given
        String count = "-1";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RoundCount(count))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(
                        ErrorMessage
                                .NEGATIVE_NUMBER_ERROR
                                .getMessage(RoundCount.MIN_COUNT));
    }
}
