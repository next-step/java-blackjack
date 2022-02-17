package blackjack.view;

import blackjack.domain.GamePlayers;
import blackjack.util.Parser;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final String SPACE = " ";
    private static final String PLAYERS_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)";
    private static final String EXIST_MIN_PLAYER = "최소한 1명의 플레이어가 있어야 합니다.";
    private static final String DUPLICATE_PLAYER = "중복되는 플레이어가 있습니다.";
    private static final String QUESTION = "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static List<String> getPlayers() {
        System.out.println(PLAYERS_INPUT_MESSAGE);

        String input = scanner.nextLine().replace(SPACE, "");

        validateEmptyValue(input);

        List<String> parseInput = Parser.parseInput(input);
        validateDuplePlayer(parseInput);

        return parseInput;
    }

    private static void validateEmptyValue(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(EXIST_MIN_PLAYER);
        }
    }

    private static void validateDuplePlayer(List<String> input) {
        Set<String> duple = new HashSet<>(input);

        if (duple.size() != input.size()) {
            throw new IllegalArgumentException(DUPLICATE_PLAYER);
        }
    }

    public static String doQuestion(GamePlayers gamePlayers) {
        System.out.println(gamePlayers.getPlayerName() + QUESTION);

        return scanner.nextLine();
    }
}
