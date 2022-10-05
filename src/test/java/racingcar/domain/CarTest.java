package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("car"));
    }

    @Test
    @DisplayName("자동차는 이동할 수 있다.")
    void 이동시_이동거리_증가() {
        // given 
        Distance distance = new Distance();

        // when
        car.move();
        distance.plus(Car.SPEED);
        
        // then 
        assertThat(car.getDistance()).isEqualTo(distance);
    }

}
