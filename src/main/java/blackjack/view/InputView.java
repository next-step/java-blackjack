package blackjack.view;

import blackjack.domain.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static String GET_USER_NAMES_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static String ASK_PLAYER_TO_ADD_CARD = "은(는) 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static String YES = "y";
    private static String NO = "n";
    private static String ANSWER_ERROR_MESSAGE = "잘못된 입력입니다. y 또는 n을 입력해 주세요.";

    public static List<String> getPlayersName() {
        Scanner SCANNER = new Scanner(System.in);
        System.out.println(GET_USER_NAMES_MESSAGE);
        String[] parsedInput = SCANNER.nextLine().split(",");
        Stream<String> players = Arrays.stream(parsedInput).map(String::trim);
        return players.collect(Collectors.toList());
    }

    public static boolean askAddCard(Player player) {
        Scanner SCANNER = new Scanner(System.in);
        System.out.println(player.getName() + ASK_PLAYER_TO_ADD_CARD);
        String answer = SCANNER.nextLine();
        if (YES.equals(answer)) {
            return true;
        }
        if (NO.equals(answer)) {
            return false;
        }
        throw new RuntimeException(ANSWER_ERROR_MESSAGE);
    }

}
