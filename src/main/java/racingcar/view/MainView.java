package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.MainController;
import racingcar.domain.Cars;
import racingcar.domain.RoundCount;

public class MainView {
    public static void carNameForm(MainController mainController) {
        printCarNameFormMessage();

        Cars.from(Console.readLine());
        mainController.requestRoundCountForm();
    }    

    public static void roundCountForm(MainController mainController) {
        roundCountFormMessage();

        RoundCount roundCount = new RoundCount(Console.readLine());
    }

    private static void roundCountFormMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    private static void printCarNameFormMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
