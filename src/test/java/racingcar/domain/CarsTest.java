package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
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
