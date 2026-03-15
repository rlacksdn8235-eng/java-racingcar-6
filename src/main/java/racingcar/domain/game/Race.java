package racingcar.domain.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Cars;
import racingcar.domain.validate.CountValidator;
import racingcar.domain.validate.NameValidator;
import racingcar.domain.validate.Validator;

public class Race {
    private final Cars cars;
    private final NameValidator nameValidator;
    private final CountValidator countValidator;

    public Race(Cars cars, NameValidator nameValidator, CountValidator countValidator) {
        this.cars = cars;
        this.nameValidator = nameValidator;
        this.countValidator = countValidator;
    }

    public void play() {
        // 자동차 입력
        inputCarName(nameValidator);
        // 몇번 시도할지 입력
        int repeatCount = inputRepeatCount(countValidator);
        // 시도횟수만큼 반복
        startRace(repeatCount);
        // 우승자 안내
        cars.findWinners();
    }

    private void inputCarName(Validator nameValidator) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        nameValidator.validate(carNames);
        cars.createCar(carNames);
    }

    private int inputRepeatCount(Validator countValidator) {
        System.out.println("시도할 회수는 몇회인가요?");
        String repeatCount = Console.readLine();
        countValidator.validate(repeatCount);
        return Integer.parseInt(repeatCount);
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
