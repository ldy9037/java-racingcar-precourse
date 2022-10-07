package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @ParameterizedTest(name = "name: {arguments}")
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("각 자동차의 이름의 길이가 지정된 범위를 벗어날 경우 예외가 발생한다.")
    void 생성시_길이_유효성검사(String name) {
        // when & then 
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(name))
                .withMessageContaining(ErrorMessage.LEVEL)
                .withMessage(
                        ErrorMessage
                                .OUT_OF_RANGE_NAME_ERROR
                                .getMessage(CarName.MIN_LENGTH, CarName.MAX_LENGTH));
    }
}