package blackjack.view;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";

    public static String inputNames() {
        System.out.println(INPUT_NAME_MESSAGE);

        return SCANNER.nextLine();
    }
}
