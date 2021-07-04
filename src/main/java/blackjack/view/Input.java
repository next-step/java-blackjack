package blackjack.view;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_ANSWER_MESSAGE = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private Input() {
    }

    public static String inputNames() {
        System.out.println(INPUT_NAME_MESSAGE);

        return scanner.nextLine();
    }

    public static String inputReceiveCardAnswer(String userName) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(System.lineSeparator())
                .append(userName)
                .append(INPUT_ANSWER_MESSAGE);
        System.out.println(stringBuilder);

        return scanner.nextLine();
    }
}
