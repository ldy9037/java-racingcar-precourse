package racingcar.domain;

public class Car implements Comparable {
    
    public static final int SPEED = 1;
    
    private final CarName carName;
    private final Distance distance = new Distance();

    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(String carName) {
        return new Car(new CarName(carName));
    }

    public void move() {
        distance.plus(SPEED);
    }

    public String getName() {
        return carName.getName();
    }

    public String getStatus() {
        return String.format("%s : %s", carName.getName(), distance.getProgressBar());
    }

    @Override
    public int compareTo(Object obj) {
        Car that = (Car) obj;
        return distance.compareTo(that.distance);
    }
}