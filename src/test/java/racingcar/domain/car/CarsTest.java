package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    void createCar_CreatesMultipleCars() {
        cars.createCar("pobi,woni,jun");
    }

    @Test
    void findWinners_SingleWinner() {
        cars.createCar("pobi,woni");
        
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    
                    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outContent));
                    
                    cars.findWinners();
                    
                    assertThat(outContent.toString()).contains("최종 우승자 : pobi");
                    System.setOut(System.out);
                },
                4, 3
        );
    }

    @Test
    void findWinners_MultipleWinners() {
        cars.createCar("pobi,woni");

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    
                    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outContent));

                    cars.findWinners();

                    assertThat(outContent.toString()).contains("최종 우승자 : pobi, woni");
                    System.setOut(System.out);
                },
                4, 5
        );
    }
}
