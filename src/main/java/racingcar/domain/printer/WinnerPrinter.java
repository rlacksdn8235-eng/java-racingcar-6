package racingcar.domain.printer;

import racingcar.domain.cars.Cars;

import java.util.List;

public class WinnerPrinter {
    private final Cars cars;

    public WinnerPrinter(Cars cars) {
        this.cars = cars;
    }

    public void print() {
        // 우승자를 찾아라
        List<String> winners = cars.findWinners();
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
            return;
        }
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
