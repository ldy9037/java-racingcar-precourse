package racingcar.domain;

public class CarName {
    
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    public CarName(String name) {
        validate(name);
    }

    private void validate(String name) {
        if (!isValidLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(String name) {
        return (name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH);
    }

}
