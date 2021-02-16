package blackjack.view;

import java.util.Scanner;

public class InputView {
    private static final String NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String MORE_CARD_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private static final Scanner scanner = new Scanner(System.in);

    public String getGamers() {
        System.out.println(NAME_MESSAGE);
        return scanner.nextLine();
    }

    public String askMoreCard(String name) {
        System.out.printf((MORE_CARD_MESSAGE) + "%n", name);
        return scanner.nextLine();
    }
}
