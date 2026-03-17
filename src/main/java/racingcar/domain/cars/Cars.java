package racingcar.domain.cars;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        cars.forEach(Car::moveCar);
    }

    public List<String> getInfos() {
        return cars.stream().map(Car::getInfo).toList();
    }

    public List<String> findWinners() {
        // 가장 멀리간 위치를 찾아라
        int maxPosition = findMaxPosition();
        // 가장 멀리간 위치에 있는 자동차를 찾아라
        return cars.stream()
                .filter(car -> car.findCarBySamePosition(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

    }
}
