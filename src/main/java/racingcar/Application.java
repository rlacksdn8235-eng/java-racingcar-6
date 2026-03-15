package racingcar;

import racingcar.domain.car.Cars;
import racingcar.domain.game.Race;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        Race race = new Race(cars);
        race.play();
    }
}
