package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    // 자동차 이름, 전진 횟수
    private String name;
    private Integer position;

    public Car(String carName) {
        this.name = carName;
        this.position = 0;
    }

    // 전진할지 말지 판단
    public void moveCar() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    // 현재 상태
    public String getInfo() {
        return name + " : " + "-".repeat(position);
    }

    public boolean findCarBySamePosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return position;
    }
}
