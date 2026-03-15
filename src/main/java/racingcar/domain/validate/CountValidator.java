package racingcar.domain.validate;

public class CountValidator implements Validator {
    @Override
    public void validate(String repeatCount) {
        checkAllRules(repeatCount);
    }

    private void checkAllRules(String repeatCount) {
        if (isNumber(repeatCount) || isPositive(repeatCount)) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    // 숫자인지, 0보다 큰지
    private boolean isNumber(String repeatCount) {
        try {
            Integer.parseInt(repeatCount);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
    private boolean isPositive(String repeatCount) {
        return Integer.parseInt(repeatCount) < 1;
    }
}
