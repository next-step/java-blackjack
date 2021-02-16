package blackjack.view;

import blackjack.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String[] getUsersName() {
        System.out.println(StringUtils.GET_USERS_NAME_MESSAGE);
        String input = scanner.nextLine();
        return input.split(",");

    }

    public static boolean getDecision(String playerName) {
        System.out.printf(StringUtils.GET_DECISION_MESSAGE, playerName);
        String input = scanner.nextLine();
        decisionValidation(input);
        return input.equals(StringUtils.YES);
    }

    private static void decisionValidation(String input) {
        if (!input.matches(StringUtils.YES_OR_NO_REGEX)) {
            throw new IllegalArgumentException("y 나 n 으로 답하셔야합니다.");
        }
    }

}
