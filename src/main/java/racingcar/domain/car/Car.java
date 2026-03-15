package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    // 자동차 이름, 전진 횟수
    private String name;
    private Integer moveCount;

    public Car(String carName) {
        this.name = carName;
        this.moveCount = 0;
    }

    // 전진할지 말지 판단
    public void moveCar() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    // 현재 상태를 출력
    public void carInfo() {
        System.out.println(name + " : " + "-".repeat(moveCount));
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
