package racingcar.domain.game;

import racingcar.domain.printer.Printer;
import racingcar.domain.race.Race;
import racingcar.domain.scanner.RepeatCountScanner;
import racingcar.domain.scanner.Scanner;
import racingcar.domain.validator.Validator;

public class Game {
    // 게임을 진행시키기 위해 필요한 상태
    private Scanner scanner; // CarName이나 RepeatCount나 변경 가능성 있음
    private final Printer printer; // WinnerPrinter
    private final Validator validator;
    private final Race race;

    public Game(Scanner scanner, Printer printer, Validator validator, Race race) {
        this.scanner = scanner;
        this.printer = printer;
        this.validator = validator;
        this.race = race;
    }

    // 게임을 진행시켜라
    public void play() {
        // 자동차 이름 입력해라
        scanner.scan();
        // 레이싱 몇번할지 입력해라
        changeScanner(new RepeatCountScanner(validator, race));
        scanner.scan();
        // 우승자를 출력해라
        printer.print();
    }

    private void changeScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
