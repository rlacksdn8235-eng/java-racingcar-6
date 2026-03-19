package racingcar;



import racingcar.domain.cars.Cars;
import racingcar.domain.game.Game;
import racingcar.domain.printer.ResultPrinter;
import racingcar.domain.printer.WinnerPrinter;
import racingcar.domain.race.Race;
import racingcar.domain.scanner.CarNameScanner;
import racingcar.domain.scanner.RepeatCountScanner;
import racingcar.domain.util.CarFactory;
import racingcar.domain.util.ScanHandler;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.RepeatCountValidator;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        Game game = new Game(
                new ScanHandler( // 자동차 이름 및 검증
                        new CarNameScanner(),
                        new CarNameValidator()
                ),
                new ScanHandler( // 반복횟수 및 검증
                        new RepeatCountScanner(),
                        new RepeatCountValidator()
                ),
                new CarFactory(cars), // 자동차 생성
                new Race(cars, new ResultPrinter(cars)), // 레이스 관련
                new WinnerPrinter(cars) // 결과 출력
        );
        game.play();
    }
}
