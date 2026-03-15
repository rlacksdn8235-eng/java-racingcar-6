package racingcar.domain.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Car;

import java.util.HashMap;
import java.util.Map;

public class Race {
    private Map<Car, Integer> carMap = new HashMap<>();

    public void play() {
        // 자동차 입력
        inputCarName();
        // 몇번 시도 ?
        // 시도횟수만큼 반복


        // 우승자 안내
    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCar(Console.readLine());
    }

    private void createCar(String carNames) {
        String[] carArray = carNames.replace(" ", "").split(",");
        for (String carName : carArray) {
            Car car = new Car(carName);
            carMap.put(car, 0);
        }
    }

    private void playingGame(int count) {

    }
}
