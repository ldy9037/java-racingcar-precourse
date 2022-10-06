package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JudgmentNumberTest {
    @ParameterizedTest(name = "number: {arguments}")
    @ValueSource(ints = {JudgmentNumber.MIN_NUMBER, JudgmentNumber.MAX_NUMBER})
    @DisplayName("0~9 사이의 랜덤 숫자를 뽑는다")
    void 특정범위의_숫자_생성(int number) {
        // when
        JudgmentNumber judgmentNumber = new JudgmentNumber(number);
        
        // then
        assertThat(judgmentNumber.getNumber()).isEqualTo(number);
    }
}
