package racingcar.domain.scanner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.race.Race;
import racingcar.domain.validator.Validator;

public class RepeatCountScanner implements Scanner {
    private final Validator validator;
    private final Race race;

    public RepeatCountScanner(Validator validator, Race race) {
        this.validator = validator;
        this.race = race;
    }

    @Override
    public void scan() {
        // 몇번 할지 입력해라
        System.out.println("시도할 회수는 몇회인가요?");
        String repeatCount = Console.readLine();
        // 문제없는지 확인해라
        validator.validate(repeatCount);
        // 반복시켜라
        race.repeatRacing(Integer.parseInt(repeatCount));
    }
}
