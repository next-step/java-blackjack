package blackjack.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_GET_CARD_OR_NOT = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAME);
        String rawPlayerNames = scanner.nextLine();
        return rawPlayerNames;
    }

    public static String inputGetCardOrNot(String name) {
        System.out.println(String.format(INPUT_GET_CARD_OR_NOT, name));
        String answer = scanner.next();
        return answer;
    }
}
