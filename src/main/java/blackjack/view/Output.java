package blackjack.view;

import java.util.List;

public class Output {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String CARD_SEPARATOR = ", ";
    private static final String SEPARATOR = "카드: ";
    private static final String DEALER_RECEIVE_CARD_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    protected Output() {
    }

    public static void printInitMessage(List<String> userNames) {
        stringBuilder.append("딜러와 ")
                .append(String.join(CARD_SEPARATOR, userNames))
                .append("에게 2장의 카드를 나누었습니다.");

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public static void printCardNames(String userName, List<String> cards) {
        stringBuilder.append(userName)
                .append(SEPARATOR)
                .append(String.join(CARD_SEPARATOR, cards));

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public static void printDealerReceiveCard() {
        stringBuilder.append(DEALER_RECEIVE_CARD_MESSAGE);

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
}
