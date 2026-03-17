package racingcar.domain.factory;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

public class CarFactory {
    private final Cars cars;

    public CarFactory(Cars cars) {
        this.cars = cars;
    }

    public void createCar(String carNames) {
        String[] carNameArray = carNames.replace(" ", "").split(",");
        for (String carName : carNameArray) {
            cars.addCar(new Car(carName));
        }
    }
}
