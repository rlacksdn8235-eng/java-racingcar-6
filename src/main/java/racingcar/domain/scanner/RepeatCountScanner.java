package racingcar.domain.scanner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.validator.RepeatCountValidator;

public class RepeatCountScanner implements Scanner {

    @Override
    public String scan() {
        // 몇번 할지 입력해라
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
