package racingcar.domain.scanner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.validator.CarNameValidator;

public class CarNameScanner implements Scanner {

    @Override
    public String scan() {
        // 자동차이름을 입력해라
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
}
