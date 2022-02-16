package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Game;
import blackjack.domain.Person;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String START_MESSAGE = "딜러와 %s 에게 2장을 나누었습니다.\n";
    private static final String CURRENT_STATE_MESSAGE = "%s 카드 : %s\n";
    private static final String RESULT_MESSAGE = "%s 카드 : %s - 결과: %s\n";
    private static final String DELIMITER = " : ";
    private static final String JOIN_DELIMITER = ", ";
    private static final int DEALER_FIRST_CARD_INDEX = 0;


    public static void printStartMessage(final Game game) {
        System.out.printf(START_MESSAGE, game.getPlayers().stream()
            .map(Person::getName)
            .collect(Collectors.joining(JOIN_DELIMITER)));
    }

    public static void printCurrentCardsState(final String name, final List<Card> cards) {
        System.out.printf(CURRENT_STATE_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(JOIN_DELIMITER)));
    }

    public static void printResult(final String name, final List<Card> cards, final int score) {
        System.out.printf(RESULT_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(JOIN_DELIMITER)), score);
    }

    public static void printDealerCard(final Dealer dealer){
        System.out.println(dealer.getName()+DELIMITER+ dealer.getCards().cards().get(DEALER_FIRST_CARD_INDEX));
    }
}
