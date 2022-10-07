package racingcar.domain;

public class Car {
    
    public static final int SPEED = 1;
    public static final int MOVE_CONDITION_NUMBER = 4; 
    
    private final CarName carName;
    private final Distance distance = new Distance();

    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(String carName) {
        return new Car(new CarName(carName));
    }

    public void move(JudgmentNumber judgmentNumber) {
        if (canMove(judgmentNumber)) {
            distance.plus(SPEED);
        } 
    }

    public CarName getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }

    private boolean canMove(JudgmentNumber judgmentNumber) {
        return (judgmentNumber.getNumber() >= MOVE_CONDITION_NUMBER);
    }
}
