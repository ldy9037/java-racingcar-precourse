package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {
    @Test
    @DisplayName("이동거리의 증가량이 음수면 예외가 발생한다")
    void 이동거리_증가량_유효성검사() {
        // when
        Distance distance = new Distance();

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> distance.plus(Distance.MIN_DISTANCE - 1));
    }
}
