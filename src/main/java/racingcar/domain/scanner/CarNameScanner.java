package racingcar.domain.scanner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.cars.Cars;
import racingcar.domain.factory.CarFactory;
import racingcar.domain.validator.Validator;

public class CarNameScanner implements Scanner {
    private final Validator validator;
    private final CarFactory carFactory;

    public CarNameScanner(Validator validator, CarFactory carFactory) {
        this.validator = validator;
        this.carFactory = carFactory;
    }

    @Override
    public void scan() {
        // 자동차이름을 입력해라
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validator.validate(carNames);
        carFactory.createCar(carNames);
    }
}
