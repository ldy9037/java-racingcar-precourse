package racingcar.controller;

import racingcar.view.MainView;

public class MainController {
    public void start() {
        requestCarNameForm();
    }

    public void requestCarNameForm() {
        MainView.carNameForm(this);
    }
}
