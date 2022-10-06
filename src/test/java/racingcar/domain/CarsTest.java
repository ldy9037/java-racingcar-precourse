package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {
    @ParameterizedTest(name = "List: {0}, expected: {1}")
    @CsvSource(value = {"ab,abc:2", "1,12,123,1234:4"}, delimiter = ':')
    @DisplayName("자동차는 쉼표로 구분해 여러대를 입력할 수 있다.")
    void 생성시_쉼표로_자동차구분(String carNames, int expected) {
        // given
        Cars cars = Cars.from(carNames);

        // then
        assertThat(cars.size()).isEqualTo(expected);
    }
}
