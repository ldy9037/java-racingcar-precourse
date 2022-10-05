package racingcar.domain;

public class RoundCount {
    
    RoundCount(String count) {
        validate(count);
    }

    private void validate(String count) {
        if (!isNumeric(count)) {
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

}
