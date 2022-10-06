package racingcar.domain;

public class JudgmentNumber {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private final int number;

    JudgmentNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
