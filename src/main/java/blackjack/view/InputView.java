package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String YES = "y";
    private static final String DELIMITER_COMMA = ",";

    public static List<String> inputNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return splitNames(input());
    }

    public static boolean isContinue() {
        return input().equals(YES);
    }

    private static String input() {
        final Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine().trim();
        validateBlank(input);

        return input;
    }

    private static List<String> splitNames(String input) {
        String[] split = input.split(DELIMITER_COMMA);

        return Arrays.stream(split)
            .collect(Collectors.toList());
    }

    private static void validateBlank(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }
}
