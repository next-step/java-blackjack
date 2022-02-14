package blackjack.view;

public class OutputView {
    private static final String REQUEST_PLAYERS_NAME = "게임에 참여할 사람의 이름을 입력하세요";
    private static final String DELIMITER = ", ";
    private static final String REQUEST_RECEIVE_CARD = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private OutputView() {}

    public static void requestPlayersName(String[] players) {
        System.out.println(REQUEST_PLAYERS_NAME);
        printGamePlayer(players);
    }

    public static void printGamePlayer(String[] players) {
        System.out.println(String.join(DELIMITER, players));
    }

    public static void printCardsSetting(String[] players) {
        System.out.println("딜러와 " + String.join(DELIMITER, players) + "에게 2장의 카드를 나누었습니다.");
    }


}
// 다이아몬드, 하트, spade, clover
