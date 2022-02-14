package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_PLAYER_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.";
    private static final String DELIMITER = ",";

    public static List<String> getPlayerName() {
        System.out.println(GET_PLAYER_MESSAGE);
        String input = scanner.nextLine();
        validateEmpty(input);

        List<String> players = splitPlayerName(input);

        return players;
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> splitPlayerName(String input) {
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
            .map(name -> name.trim())
            .filter(name -> !name.isEmpty())
            .collect(Collectors.toList());
    }
}
