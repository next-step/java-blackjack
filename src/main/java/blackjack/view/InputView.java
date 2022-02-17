package blackjack.view;

import blackjack.utils.Spliter;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INIT_PLAYER_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String MORE_CARD_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String BLANK_EXCEPTION = "1명 이상의 플레이어 이름을 입력해주세요.";
    private static final String WRONG_ANSWER_EXCEPTION = "응답은 y 또는 n이어야 합니다.";
    private static final String YES = "y";
    private static final String NO = "n";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static List<String> inputPlayerNames() {
        System.out.println(INIT_PLAYER_MESSAGE);
        String input = scanner.nextLine();
        checkBlank(input);
        return Spliter.commaSplit(input);
    }

    public static boolean askHitOrStand(String playerName) {
        System.out.printf((MORE_CARD_MESSAGE) + "%n", playerName);
        String input = scanner.nextLine().trim();
        checkResponse(input);
        return input.equals(YES);
    }

    private static void checkResponse(String input) {
        checkBlank(input);
        if (!input.equals(YES) && !input.equals(NO)) {
            throw new IllegalArgumentException(WRONG_ANSWER_EXCEPTION);
        }
    }

    private static void checkBlank(String text) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException(BLANK_EXCEPTION);
        }
    }

}
