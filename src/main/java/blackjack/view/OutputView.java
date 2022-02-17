package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.player.Dealer;
import blackjack.domain.Game;
import blackjack.domain.state.Gameable;
import blackjack.domain.player.Person;
import blackjack.domain.player.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String START_MESSAGE = "딜러와 %s 에게 2장을 나누었습니다.\n";
    private static final String CURRENT_STATE_MESSAGE = "%s 카드 : %s\n";
    private static final String RESULT_MESSAGE = "%s 카드 : %s - 결과: %s\n";
    private static final String GIVE_CARD_TO_DEALER_MESSAGE = "\n딜러는 16 이하라 한장의 카드를 더 받았습니다\n";
    private static final String DELIMITER = " : ";
    private static final String JOIN_DELIMITER = ", ";
    private static final int DEALER_FIRST_CARD_INDEX = 0;

    public static void printStartMessage(final Game game) {
        System.out.printf(START_MESSAGE, game.getPlayers().stream()
            .map(Person::getName)
            .collect(Collectors.joining(JOIN_DELIMITER)));
    }

    public static void printCurrentCardsState(final String name, final Gameable cards) {
        System.out.printf(CURRENT_STATE_MESSAGE, name,
            cards.cards().getCards().stream().map(Card::toString)
                .collect(Collectors.joining(JOIN_DELIMITER)));
    }

    public static void printResult(final String name, final List<Card> cards, final int score) {
        System.out.printf(RESULT_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(JOIN_DELIMITER)), score);
    }

    public static void printGameResults(Dealer dealer, List<Player> players) {
        printResult(dealer.getName(), dealer.getCards().cards().getCards(),
            dealer.getCards().cards().sumScore()
        );

        players.forEach(player -> printResult(player.getName(),
            player.getCards().cards().getCards(),
            player.getCards().cards().sumScore())
        );
    }

    public static void printDealerCard(final Dealer dealer) {
        System.out.println(dealer.getName() + DELIMITER + dealer.getCards().cards().getCards()
            .get(DEALER_FIRST_CARD_INDEX));
    }

    public static void printPlayerCard(final List<Player> players) {
        players.forEach(
            player -> OutputView.printCurrentCardsState(player.getName(), player.getCards()));
    }

    public static void printMessageToGiveCardToDealer() {
        System.out.println(GIVE_CARD_TO_DEALER_MESSAGE);
    }

    public static void printGameWinOrLose(Person person, List<Integer> gameResult) {
        System.out.printf("%s : %d승 %d패%n", person.getName(), gameResult.get(0), gameResult.get(1));
    }
}
