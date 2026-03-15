package racingcar;

import racingcar.domain.car.Cars;
import racingcar.domain.game.Race;
import racingcar.domain.validate.CountValidator;
import racingcar.domain.validate.NameValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NameValidator nameValidator = new NameValidator();
        CountValidator countValidator = new CountValidator();
        Cars cars = new Cars();
        Race race = new Race(cars, nameValidator, countValidator);
        race.play();
    }
}
