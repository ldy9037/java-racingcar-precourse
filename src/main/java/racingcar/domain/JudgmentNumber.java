package racingcar.domain;

public class JudgmentNumber {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private final int number;

    JudgmentNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(int number) {
        return (number >= MIN_NUMBER && number <= MAX_NUMBER);  
    }
}
