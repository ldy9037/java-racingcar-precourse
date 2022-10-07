package racingcar.domain;

import java.util.Objects;

public class Distance {
    
    public static final int MIN_DISTANCE = 0;
    
    private int distance = 0;

    public void plus(int distance) {
        validate(distance);
        this.distance += distance;
    }
    
    private void validate(int distance) {
        if (isNegativeNumber(distance)) {
            throw new IllegalArgumentException(
                    ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isNegativeNumber(int distance) {
        return (distance < MIN_DISTANCE);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Distance)) {
            return false;
        }

        Distance that = (Distance) obj;

        return (this.distance == that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
