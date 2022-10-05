package racingcar.domain;

public class RoundCount {
    
    public static final int MIN_COUNT = 0;

    RoundCount(String count) {
        validate(count);
    }

    private void validate(String count) {
        if (!isNumeric(count)) {
            throw new IllegalArgumentException();
        }

        if (isNegativeNumber(Integer.parseInt(count))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        
        return true;
    }

    private boolean isNegativeNumber(int count) {
        return (count < MIN_COUNT);
    }

}
