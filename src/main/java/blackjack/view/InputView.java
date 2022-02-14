package blackjack.view;

import java.util.Scanner;

public class InputView {

    private static final String INIT_PLAYER_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String CARD_DISTRIBUTE_MESSAGE = "딜러와 %s에게 2장의 나누었습니다.";
    private static final String MORE_CARD_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private static Scanner scanner = new Scanner(System.in);

    public void inputPlayerNames() {
        System.out.println(INIT_PLAYER_MESSAGE);
    }

    public void getUserResponse() {

    }

}
