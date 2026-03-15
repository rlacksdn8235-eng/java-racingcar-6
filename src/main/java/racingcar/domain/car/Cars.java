package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void createCar(String carNames) {
        String[] carNameArray = carNames.replace(" ", "").split(",");
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void moveCars() {
        cars.forEach(Car::moveCar);
    }

    public void printInfos() {
        cars.forEach(Car::carInfo);
    }

    public void findWinners() {
        int maxCount = findMaxCount();
        List<String> winnerNames = cars.stream()
                .filter(car -> car.getMoveCount() == maxCount)
                .map(Car::getName)
                .toList();

        printWinners(winnerNames);
    }

    private int findMaxCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

    }

    private void printWinners(List<String> winnerNames) {
        if (winnerNames.size() == 1) {
            System.out.println("최종 우승자 : " + winnerNames.get(0));
        }

        String winner = winnerNames.get(0);
        for(int i = 1 ; i < winnerNames.size() ; i++) {
            winner += ", " + winnerNames.get(i);
        }
        System.out.println("최종 우승자 : " + winner);
    }
}
