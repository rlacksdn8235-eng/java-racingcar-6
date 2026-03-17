package racingcar.domain.printer;

import racingcar.domain.cars.Cars;

import java.util.List;

public class ResultPrinter implements Printer {
    private final Cars cars;

    public ResultPrinter(Cars cars) {
        this.cars = cars;
    }

    @Override
    public void print() {
        System.out.println("실행 결과");
        List<String> result = cars.getInfos();
        for(String info : result) {
            System.out.println(info);
        }
        System.out.println();
    }
}
