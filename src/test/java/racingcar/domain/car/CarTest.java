package racingcar.domain.car;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void constructor_SetsNameCorrectly() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void moveCar_ForwardWhenRandomIsFourOrGreater() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveCar();
                    assertThat(car.getMoveCount()).isEqualTo(1);
                },
                4
        );
    }

    @Test
    void moveCar_StopWhenRandomIsThreeOrLess() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveCar();
                    assertThat(car.getMoveCount()).isEqualTo(0);
                },
                3
        );
    }
}
