package blackjack.view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String DRAW_FLAG_INPUT_MESSAGE_FORMAT = "%s. 한장의 카드를 더 받으실건가요?(예는 y, 아니오는 n)%n";

    public String inputPlayers() {
        System.out.println(PLAYERS_INPUT_MESSAGE);
        return input();
    }

    public String inputDrawFlag(String name) {
        System.out.printf(DRAW_FLAG_INPUT_MESSAGE_FORMAT, name);
        return input();
    }

    private String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
