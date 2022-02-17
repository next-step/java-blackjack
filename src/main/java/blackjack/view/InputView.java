package blackjack.view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String DRAW_FLAG_INPUT_MESSAGE_FORMAT = "%s. 한장의 카드를 더 받으실건가요?(예는 y, 아니오는 n)%n";
    private static final String DRAW_FLAG_REGEX = "[ynYN]";
    private static final String INVALID_DRAW_FLAG_EXCEPTION_MESSAGE = "[ERROR] y 또는 n만 입력 가능합니다";

    private InputView() {}

    public static String inputPlayerNames() {
        System.out.println(PLAYERS_INPUT_MESSAGE);
        return input();
    }

    public static String inputDrawFlag(final String name) {
        System.out.printf(DRAW_FLAG_INPUT_MESSAGE_FORMAT, name);
        final String input = input();
        validateDrawFlag(input);
        return input;
    }

    private static void validateDrawFlag(final String input) {
        if (!input.matches(DRAW_FLAG_REGEX)) {
            throw new IllegalArgumentException(INVALID_DRAW_FLAG_EXCEPTION_MESSAGE);
        }
    }

    private static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
