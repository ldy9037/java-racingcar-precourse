package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.RoundCount;
import racingcar.view.MainView;

public class MainController {

    private Game game = null;

    public void start() {
        requestGameInfoForm();
    }

    public void requestGameInfoForm() {
        MainView.gameInfoForm(this);
    }

    public void requestSetGameInfo(Cars cars, RoundCount roundCount){
        game = new Game(cars, roundCount);

        requestStartRound();
    }

    public void requestStartRound() {
        MainView.printStatus(game.round());
    }
}
