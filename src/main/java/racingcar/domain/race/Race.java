package racingcar.domain.race;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.cars.Cars;
import racingcar.domain.printer.Printer;
import racingcar.domain.validator.RepeatCountValidator;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.Validator;

public class Race {
    private final Cars cars;
    private final Printer printer;

    public Race(Cars cars, Printer printer) {
        this.cars = cars;
        this.printer = printer;
    }

    public void repeatRacing(int repeatCount) {
        for (int i = 0 ; i < repeatCount ; i++) {
            // 모든 자동차를 전진시켜라
            cars.moveCars();
            // 실행 결과를 출력해라
            printer.print();
        }
    }
}
