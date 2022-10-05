package racingcar.domain;

public class Car {
    
    public static final int SPEED = 1;

    private final CarName carName;
    private final Distance distance = new Distance();

    Car(CarName carName) {
        this.carName = carName;
    }

    public void move() {
        distance.plus(SPEED);
    }

    public Distance getDistance() {
        return distance;
    }
}
