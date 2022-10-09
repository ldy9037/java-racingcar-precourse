package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("진행상황을 확인한다")
    void 자동차_전체현황_확인() {
        // given
        String names = "car1,car2";
        Cars cars = Cars.from(names);

        // when
        List<String> status = cars.getStatusList();

        // then
        assertThat(status).hasSize(cars.size());        
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승한다.")
    void 이동거리가_가장긴_자동차_확인() {
        // given
        Car slowCar = Car.from("slow");
        Car fastCar1 = Car.from("fast1");
        Car fastCar2 = Car.from("fast2");
        
        // when 
        fastCar1.move();   
        fastCar2.move();   
        Cars cars = Cars.of(slowCar, fastCar1, fastCar2);

        // then
        assertThat(cars.getLongestDistanceCars()).containsExactly(fastCar1, fastCar2);
    }
}
