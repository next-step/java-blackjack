package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PARTICIPANTS_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String YES_OR_NO_MESSAGE = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputPlayers() {
        String players = getInputValueWithMessage(PARTICIPANTS_MESSAGE);
        return Arrays.stream(players.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public static String inputYesOrNo(String name) {
        return getInputValueWithMessage(name + YES_OR_NO_MESSAGE);
    }

    public static String getInputValueWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine().trim();
    }
}
