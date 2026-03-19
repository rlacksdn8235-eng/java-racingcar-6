package racingcar.domain.util;

import racingcar.domain.scanner.Scanner;
import racingcar.domain.validator.Validator;

public class ScanHandler {
    private final Scanner scanner;
    private final Validator validator;

    public ScanHandler(Scanner scanner, Validator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    public String scanAndValidate() {
        // 입력해라
        String repeatCount = scanner.scan();
        // 검증해라
        validator.validate(repeatCount);
        return repeatCount;
    }
}
