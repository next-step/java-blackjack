package blackjack.view;

import blackjack.model.Player;

import java.util.List;

public class Output {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String FIRST_SENTENCE_AT_INITIAL_MESSAGE = "딜러와 ";
    private static final String LAST_SENTENCE_AT_INITIAL_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    private static final String CARD_SEPARATOR = ", ";
    private static final String SEPARATOR = "카드: ";
    private static final String DEALER_RECEIVE_CARD_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String FINAL_VALUE = " - 결과: ";
    private static final String RESULT_MESSAGE = "## 최종 승패";
    private static final String COLON = ": ";
    private static final int INITIALIZE_VALUE = 0;


    protected Output() {
    }

    public static void printInitMessage(List<String> userNames) {
        stringBuilder.append(FIRST_SENTENCE_AT_INITIAL_MESSAGE)
                .append(String.join(CARD_SEPARATOR, userNames))
                .append(LAST_SENTENCE_AT_INITIAL_MESSAGE);

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printDealerFirstCardName(String userName, String card) {
        stringBuilder.append(userName)
                .append(COLON)
                .append(card);

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printCardNames(String userName, List<String> cards) {
        stringBuilder.append(userName)
                .append(SEPARATOR)
                .append(String.join(CARD_SEPARATOR, cards));

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printDealerReceiveCard() {
        stringBuilder.append(System.lineSeparator())
                .append(DEALER_RECEIVE_CARD_MESSAGE);

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printPlayerCardInformation(Player player) {
        stringBuilder.append(player.getName())
                .append(SEPARATOR)
                .append(String.join(CARD_SEPARATOR, player.getCardNames()))
                .append(FINAL_VALUE)
                .append(player.getCardValueSum());

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printResult(String result) {
        System.out.println("\n" + RESULT_MESSAGE);
        System.out.println(result);
    }
}
