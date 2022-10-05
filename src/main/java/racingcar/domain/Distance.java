package racingcar.domain;

public class Distance {
    
    public static final int MIN_DISTANCE = 0;
    
    private int distance = 0;

    public void plus(int distance) {
        validate(distance);
        this.distance += distance;
    }
    
    private void validate(int distance) {
        if (isNegativeNumber(distance)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNegativeNumber(int distance) {
        return (distance < MIN_DISTANCE);
    }
}
