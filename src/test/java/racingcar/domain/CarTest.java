package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    
    private Car car;
    private String name;

    @BeforeEach
    void setUp() {
        name = "car";
        car = Car.from(name);
    }

    @Test
    @DisplayName("숫자가 4이상이면 전진한다.")
    void 이동시_이동거리_증가() {
        // given 
        Distance distance = new Distance();

        // when
        car.move(JudgmentNumber.from(Car.MOVE_CONDITION_NUMBER));
        distance.plus(Car.SPEED);
        
        // then 
        assertThat(car.getDistance()).isEqualTo(distance);
    }

    @Test
    @DisplayName("자동차 이름을 확인한다.")
    void 자동차이름_확인() {
        // when 
        CarName carName = car.getCarName();

        // then
        assertThat(carName.getName()).isEqualTo(name);
    }
}
