package racingcar.view;

import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.MainController;
import racingcar.domain.Cars;
import racingcar.domain.RoundCount;

public class MainView {
    public static void gameInfoForm(MainController mainController) {
        mainController.requestSetGameInfo(carNameForm(), roundCountForm());
    }

    public static void printResultInfo(MainController mainController) {
        System.out.println("실행 결과");
        mainController.requestStartRound();
    }

    public static void printStatus(MainController mainController, List<String> statusList) {
        for (String status : statusList) {
            System.out.println(status);
        }

        printNewLine();

        mainController.requestStartRound();
    }

    private static Cars carNameForm() {
        Cars cars = null;
        
        while (Objects.isNull(cars)) {
            printCarNameFormMessage();
            cars = inputCarNames();
            printNewLine();
        }

        return cars;
    }    

    private static RoundCount roundCountForm() {
        RoundCount roundCount = null;

        while (Objects.isNull(roundCount)) {
            printRoundCountFormMessage();
            roundCount = inputRoundCount();
            printNewLine();
        }

        return roundCount;
    }

    private static Cars inputCarNames() {
        Cars result = null;

        try {
            result = Cars.from(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private static RoundCount inputRoundCount() {
        RoundCount result = null;

        try {
            result = new RoundCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private static void printRoundCountFormMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    private static void printCarNameFormMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void printNewLine() {
        System.out.println();
    }
}
