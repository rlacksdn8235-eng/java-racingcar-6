package racingcar.domain.car;

public class Car {
    // 자동차 이름, 전진 횟수
    private String carName;
    private Integer moveCount;

    // 전진할지 말지 판단


    public Car(String carName) {
        this.carName = carName;
        this.moveCount = 0;
    }
}
