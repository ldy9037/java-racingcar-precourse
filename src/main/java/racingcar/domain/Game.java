package racingcar.domain;

import java.util.List;

public class Game {

    private final Cars cars;
    private final RoundCount roundCount;

    public Game(Cars cars, RoundCount roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public List<String> round() {
        cars.moveAllByRandom();
        return cars.getStatusList();
    }
}
