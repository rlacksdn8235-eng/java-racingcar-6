package racingcar;

import racingcar.domain.cars.Cars;
import racingcar.domain.factory.CarFactory;
import racingcar.domain.game.Game;
import racingcar.domain.printer.ResultPrinter;
import racingcar.domain.printer.WinnerPrinter;
import racingcar.domain.race.Race;
import racingcar.domain.scanner.CarNameScanner;
import racingcar.domain.scanner.RepeatCountScanner;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.RepeatCountValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        CarFactory carFactory = new CarFactory(cars);
        ResultPrinter resultPrinter = new ResultPrinter(cars);
        WinnerPrinter winnerPrinter = new WinnerPrinter(cars);
        CarNameValidator carNameValidator = new CarNameValidator();
        RepeatCountValidator repeatCountValidator = new RepeatCountValidator();
        CarNameScanner carNameScanner = new CarNameScanner(carNameValidator, carFactory);
        Race race = new Race(cars, resultPrinter);
        Game game = new Game(carNameScanner, winnerPrinter, repeatCountValidator, race);
        game.play();
    }
}
