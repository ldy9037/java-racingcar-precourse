package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JudgmentNumberTest {
    @Test
    @DisplayName("0~9 사이의 랜덤 숫자를 뽑는다")
    void 특정범위의_숫자_생성() {
        // when
        JudgmentNumber judgmentNumber = JudgmentNumber.newJudgmentNumber();
        
        // then
        assertThat(judgmentNumber.getNumber())
                .isGreaterThan(JudgmentNumber.MIN_NUMBER)
                .isLessThan(JudgmentNumber.MAX_NUMBER);
    }

    @ParameterizedTest(name = "number: {arguments}")
    @ValueSource(ints = {JudgmentNumber.MIN_NUMBER - 1, JudgmentNumber.MAX_NUMBER + 1})
    @DisplayName("0 ~ 9 사이의 숫자가 아니면 예외가 발생한다.")
    void 특범위를_벗어난_숫자_생성(int number) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> JudgmentNumber.from(number));
    }
}
