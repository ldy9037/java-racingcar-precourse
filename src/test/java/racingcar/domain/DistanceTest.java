package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DistanceTest {
    @Test
    @DisplayName("이동거리의 증가량이 음수면 예외가 발생한다")
    void 이동거리_증가량_유효성검사() {
        // when
        Distance distance = new Distance();

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> distance.plus(Distance.MIN_DISTANCE - 1))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(
                        ErrorMessage
                                .NEGATIVE_NUMBER_ERROR
                                .getMessage());
    }

    @Test
    @DisplayName("이동거리를 프로그래스바로 변환시킨다.")
    void 이동거리를_프로그래스바로_변환() {
        // given
        int move = 2;
        
        // when
        Distance distance = new Distance();
        distance.plus(move);
        
        // then
        assertThat(distance.getProgressBar())
                .hasSize(move)
                .contains(Distance.PROGRESS_BAR_TYPE);
    }

    @ParameterizedTest(name = "operand1: {0}, operand2: {1}, expected: {2}")
    @CsvSource(value = {"2:1:1", "2:2:0", "2:3:-1"}, delimiter = ':')
    @DisplayName("이동거리를 비교한다")
    void 이동거리를_비교(int operand1, int operand2, int expected) {
        // given
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();

        // when
        distance1.plus(operand1);
        distance2.plus(operand2);

        assertThat((distance1.compareTo(distance2))).isEqualTo(expected);
    }
}
