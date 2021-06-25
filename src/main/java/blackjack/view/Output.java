package blackjack.view;

import blackjack.model.Dealer;
import blackjack.model.User;
import blackjack.model.Users;

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


    private Output() {
    }

    public static void printInitMessage(List<String> userNames) {
        stringBuilder.append(FIRST_SENTENCE_AT_INITIAL_MESSAGE)
                .append(String.join(CARD_SEPARATOR, userNames))
                .append(LAST_SENTENCE_AT_INITIAL_MESSAGE);

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printInitialInformation(Dealer dealer, Users users) {
        Output.printDealerFirstCardName(dealer.getName(), dealer.getFirstCard());
        printUsersCardNames(users);
    }

    private static void printUsersCardNames(Users users) {
        for (User user : users.getUsers()) {
            Output.printCardNames(user.getName(), user.getCardNames());
        }
    }

    private static void printDealerFirstCardName(String userName, String card) {
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


    public static void printFinalInformation(Dealer dealer, Users users) {
        Output.printDealerCardInformation(dealer);
        printUsersCardInformation(users);
    }

    private static void printUsersCardInformation(Users users) {
        for (User user : users.getUsers()) {
            Output.printUserCardInformation(user);
        }
    }

    private static void printDealerCardInformation(Dealer dealer) {
        stringBuilder.append(dealer.getName())
                .append(SEPARATOR)
                .append(String.join(CARD_SEPARATOR, dealer.getCardNames()))
                .append(FINAL_VALUE)
                .append(dealer.getCardValueSum());

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printUserCardInformation(User user) {
        stringBuilder.append(user.getName())
                .append(SEPARATOR)
                .append(String.join(CARD_SEPARATOR, user.getCardNames()))
                .append(FINAL_VALUE)
                .append(user.getCardValueSum());

        System.out.println(stringBuilder);
        stringBuilder.setLength(INITIALIZE_VALUE);
    }

    public static void printResult(String result) {
        System.out.println("\n" + RESULT_MESSAGE);
        System.out.println(result);
    }
}
