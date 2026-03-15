package racingcar.domain.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Cars;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        // 자동차 입력
        inputCarName();
        // 몇번 시도 ?
        System.out.println("시도할 회수는 몇회인가요?");
        // 시도횟수만큼 반복
        startRace(Integer.parseInt(Console.readLine()));
        // 우승자 안내
        cars.findWinners();
    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars.createCar(Console.readLine());
    }

    private void startRace(int repeatCount) {
        System.out.println("실행 결과");
        for (int i = 0 ; i < repeatCount ; i++) {
            // 전진할지 말지 판단
            cars.moveCars();
            // 실행 결과를 출력
            cars.printInfos();
            System.out.println();
        }
    }
}
