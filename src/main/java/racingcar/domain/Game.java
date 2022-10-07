package racingcar.domain;

public class Game {

    private final Cars cars;

    Game(Cars cars) {
        this.cars = cars;
    }

    public void round() {
        cars.moveAllByRandom();
    }
}
