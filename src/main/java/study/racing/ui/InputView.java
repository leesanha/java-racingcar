package study.racing.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import study.racing.utils.ScannerUtils;

public final class InputView {

    private static final String QUETION_ABOUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUETION_ABOUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    public static final String DELIMITER = ",";
    public static final int NAME_LENGTH_LIMIT = 5;

    private InputView() {
    }

    public static List<String> acceptCarNames() {
        System.out.println(QUETION_ABOUT_CAR_NAMES);
        String inputCarNames = ScannerUtils.nextLine();
        List<String> carNames = Arrays.stream(inputCarNames.split(DELIMITER)).collect(Collectors.toList());

        validateCarNamesOrThrow(carNames);
        return carNames;
    }

    private static void validateCarNamesOrThrow(List<String> carNames) {
        boolean isExistExeedName = carNames.stream()
                                           .anyMatch(name -> name.length() > NAME_LENGTH_LIMIT);
        if (isExistExeedName) {
            throw new RuntimeException("car name length must not greater than " + NAME_LENGTH_LIMIT);
        }
    }

    public static int acceptTryCount() {
        System.out.println(QUETION_ABOUT_TRY_COUNT);
        return ScannerUtils.nextInt();
    }
}
