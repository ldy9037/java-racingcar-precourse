package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.MainController;
import racingcar.domain.Car;
import racingcar.domain.CarName;

public class MainView {
    public static void carNameForm(MainController mainController) {
        printCarNameFormMessage();
        
        CarName carName = new CarName(Console.readLine());
        Car car = new Car(carName);
    }    

    private static void printCarNameFormMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
