package blackjack.view;

import blackjack.domain.gameplayer.GamePlayer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_PLAYER_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.";
    private static final String QUESTION_ACCEPT_CARD_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String DELIMITER = ",";

    public static List<String> getPlayerName() {
        System.out.println(GET_PLAYER_MESSAGE);
        String input = scanner.nextLine();
        validateEmpty(input);

        return splitPlayerName(input);
    }

    public static boolean getPlayerChoice(GamePlayer player) {
        try {
            System.out.println(String.format(QUESTION_ACCEPT_CARD_MESSAGE, player.getName()));
            String input = scanner.nextLine();
            validateEmpty(input);
            return input.equals("y");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getPlayerChoice(player);
        }
    }

    private static List<String> splitPlayerName(String input) {
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
            .map(String::trim)
            .filter(name -> !name.isEmpty())
            .collect(Collectors.toList());
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
