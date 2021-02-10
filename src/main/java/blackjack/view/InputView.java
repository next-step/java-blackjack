package blackjack.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    private static final String GET_USERS_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";

    public static String[] getUsersName() {
        System.out.println(GET_USERS_NAME_MESSAGE);
        String input = scanner.nextLine();
        return input.split(",");

    }
}
