package racingcar.domain.validate;

import java.util.Arrays;

public class NameValidator implements Validator {
    @Override
    public void validate(String carNames) {
        String[] carNameArray = carNames.replace(" ", "").split(",");
        for (String carName : carNameArray) {
            checkAllRules(carNameArray, carName);
        }
    }

    private void checkAllRules(String[] carNameArray, String carName) {
        if (isValidLength(carName) ||
                duplicateName(carNameArray, carName) ||
                carNameArray.length < 2
        ) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    // 6자이상, 중복이름, 차이름갯수가 0이나 1
    private boolean isValidLength(String carName) {
        return carName.length() > 5;
    }
    private boolean duplicateName(String[] carNameArray, String carName) {
        return Arrays.stream(carNameArray)
                .filter(name -> name.equals(carName))
                .count() != 1;
    }
}
