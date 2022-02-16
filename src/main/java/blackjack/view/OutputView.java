package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Person;
import blackjack.domain.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String START_MESSAGE = "딜러와 %s 에게 2장을 나누었습니다.\n";
    private static final String CURRENT_STATE_MESSAGE = "%s 카드 : %s\n";
    private static final String RESULT_MESSAGE = "%s 카드 : %s - 결과: %s\n";

    public static void printStartMessage(final List<Player> players) {
        String playerName = players.stream().map(Person::getName).collect(Collectors.joining(", "));
        System.out.printf(START_MESSAGE, playerName);
    }

    public static void printCurrentCardsState(final String name, final List<Card> cards) {
        System.out.printf(CURRENT_STATE_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(", ")));
    }

    public static void printResult(final String name, final List<Card> cards, final int score) {
        System.out.printf(RESULT_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(", ")), score);
    }
}
