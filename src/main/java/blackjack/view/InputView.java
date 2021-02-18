package blackjack.view;

import java.util.Scanner;

import static blackjack.utils.StringUtils.COMMA;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    private static final String YES = "y";
    private static final String YES_OR_NO_REGEX = "y|n";
    private static final String GET_USERS_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String GET_DECISION_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";
    private static final String GET_MONEY_MESSAGE = "%s의 배팅 금액은?\n";

    public static String[] getUsersName() {
        System.out.println(GET_USERS_NAME_MESSAGE);
        String input = scanner.nextLine();
        return input.split(COMMA);

    }

    public static boolean getDecision(String playerName) {
        System.out.printf(GET_DECISION_MESSAGE,playerName);
        String input = scanner.nextLine();
        decisionValidation(input);
        return input.equals(YES);
    }

    private static void decisionValidation(String input) {
        if (!input.matches(YES_OR_NO_REGEX)) {
            throw new IllegalArgumentException("y 나 n 으로 답하셔야합니다.");
        }
    }

    public static int getMoney(String name) {
        System.out.printf(GET_MONEY_MESSAGE,name);
        return Integer.parseInt(scanner.nextLine());
    }

}
