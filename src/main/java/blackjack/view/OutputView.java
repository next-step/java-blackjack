package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String GAME_INITIAL_MANAGER = "딜러와 %s에게 2장의 카드를 나누었습니다.";
    private static final String COMMA = ", ";
    private static final String CARDS_LOG = "%s: %s";

    public static void printInitialMessage(List<Player> players) {
        String playerNames = players.stream()
            .map(Player::getName)
            .collect(Collectors.joining(COMMA));

        System.out.println(String.format(GAME_INITIAL_MANAGER, playerNames));
    }

    public static void printCardStatus(Player player) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Card> cards = player.getCards();
        for (Card card : cards) {
            stringBuilder.append(card.getPoint())
                .append(card.getSymbol())
                .append(COMMA);
        }
        System.out.println(String.format(CARDS_LOG, player.getName(), stringBuilder.toString()));
    }
}
