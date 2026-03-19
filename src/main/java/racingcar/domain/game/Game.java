package racingcar.domain.game;

import racingcar.domain.util.CarFactory;
import racingcar.domain.printer.WinnerPrinter;
import racingcar.domain.race.Race;
import racingcar.domain.util.ScanHandler;

public class Game {
    private final ScanHandler carNameScanHandler;
    private final ScanHandler repeatCountScanHandler;
    private final WinnerPrinter winnerPrinter;
    private final Race race;
    private final CarFactory carFactory;

    public Game(ScanHandler carNameScanHandler, ScanHandler repeatCountScanHandler, WinnerPrinter winnerPrinter, Race race, CarFactory carFactory) {
        this.carNameScanHandler = carNameScanHandler;
        this.repeatCountScanHandler = repeatCountScanHandler;
        this.winnerPrinter = winnerPrinter;
        this.race = race;
        this.carFactory = carFactory;
    }

    // 게임을 진행시켜라
    public void play() {
        // 자동차 이름 입력해라
        String carNames = carNameScanHandler.scanAndValidate();
        // 자동차 생성해라
        carFactory.createCar(carNames);
        // 반복 횟수 입력받아라
        String repeatCount = repeatCountScanHandler.scanAndValidate();
        // 레이싱 반복시켜라
        race.repeatRacing(Integer.parseInt(repeatCount));
        // 우승자를 출력해라
        winnerPrinter.print();
    }

}
