package racingcar.domain.race;

import racingcar.domain.cars.Cars;
import racingcar.domain.printer.ResultPrinter;

public class Race {
    private final Cars cars;
    private final ResultPrinter resultPrinter;

    public Race(Cars cars, ResultPrinter printer) {
        this.cars = cars;
        this.resultPrinter = printer;
    }

    // 레이스 반복
    public void repeatRacing(int repeatCount) {
        for (int i = 0 ; i < repeatCount ; i++) {
            race();
        }
    }

    private void race() {
        // 모든 자동차를 전진시켜라
        cars.moveCars();
        // 실행 결과를 출력해라
        resultPrinter.print();
    }
}
