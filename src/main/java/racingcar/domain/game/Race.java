package racingcar.domain.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> carList = new ArrayList<>();

    public void play() {
        // 자동차 입력
        inputCarName();
        // 몇번 시도 ?
        System.out.println("시도할 회수는 몇회인가요?");
        // 시도횟수만큼 반복
        startRace(Integer.parseInt(Console.readLine()));
        // 우승자 안내

    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCar(Console.readLine());
    }

    private void createCar(String carNames) {
        String[] carArray = carNames.replace(" ", "").split(",");
        for (String carName : carArray) {
            carList.add(new Car(carName));
        }
    }

    private void startRace(int repeatCount) {
        System.out.println("실행 결과");
        for (int i = 0 ; i < repeatCount ; i++) {
            // 전진할지 말지 판단
            carList.forEach(Car::moveCar);
            // 실행 결과를 출력
            carList.forEach(Car::carInfo);
            System.out.println();
        }
    }
}
