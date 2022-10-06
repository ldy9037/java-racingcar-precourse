package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private final List<Car> cars;
    
    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String carNames) {
        List<Car> cars = new ArrayList<>();
        
        for (String name : carNames.split(",")) {
            cars.add(Car.from(name));
        }

        return new Cars(cars);
    }

    public int size() {
        return cars.size();
    }
}
