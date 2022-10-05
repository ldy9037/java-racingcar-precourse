package racingcar.domain;

public class CarName {
    
    public static final int MAX_LENGTH = 5;

    CarName(String name) {
        validate(name);
    }

    private void validate(String name) {
        if (!isValidLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(String name) {
        return (name.length() <= MAX_LENGTH);
    }

}
