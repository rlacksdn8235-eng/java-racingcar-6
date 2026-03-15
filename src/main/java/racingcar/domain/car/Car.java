package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    // 자동차 이름, 전진 횟수
    private String carName;
    private Integer moveCount;

    // 전진할지 말지 판단
    public void moveCar() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    public Car(String carName) {
        this.carName = carName;
        this.moveCount = 0;
    }
}
