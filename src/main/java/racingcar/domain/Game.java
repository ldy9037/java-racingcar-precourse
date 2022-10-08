package racingcar.domain;

import java.util.List;

public class Game {

    private final Cars cars;
    private final RoundCount roundCount;

    private int currentRound = 0;

    public Game(Cars cars, RoundCount roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public boolean isOver() {
        return (currentRound >= roundCount.getCount());
    }

    public List<String> round() {
        validateRound();
        
        currentRound++;

        cars.moveAllByRandom();
        return cars.getStatusList();
    }

    private void validateRound() {
        if (isOver()) {
            throw new IllegalStateException(
                    ErrorMessage.START_ROUND_WHEN_GAME_OVER_ERROR.getMessage());
        }
    }
}
