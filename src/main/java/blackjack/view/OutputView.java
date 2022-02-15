package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.GamePlayers;
import blackjack.domain.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String GAME_INITIAL_MANAGER = "딜러와 %s에게 2장의 카드를 나누었습니다.";
    private static final String COMMA = ", ";
    private static final String CARDS_LOG = "%s: %s";
    private static final String QUESTION_ACCEPT_CARD_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String DEALER_RECEIVE_ONE_CARD_MESSAGE = "딜러는 한장의 카드를 더 받았습니다.";
    private static final String RESULT_CARDS_LOG = "%s카드: %s - 결과: %d";

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
            stringBuilder.append(card.getName())
                .append(card.getSymbol())
                .append(COMMA);
        }
        System.out.println(String.format(CARDS_LOG, player.getName(), stringBuilder.toString()));
    }

    public static void printQuestionAcceptCard(Player player) {
        System.out.println(String.format(QUESTION_ACCEPT_CARD_MESSAGE, player.getName()));
    }

    public static void printDealerAcceptCard() {
        System.out.println(DEALER_RECEIVE_ONE_CARD_MESSAGE);
    }

    public static void printResult(GamePlayers gamePlayers) {
        List<Player> players = gamePlayers.getPlayers();

        for (Player player : players) {
            String cardNameWithSymbol = player.getCards().stream()
                .map(card -> card.getName() + card.getSymbol())
                .collect(Collectors.joining(COMMA));

            System.out.println(String.format(RESULT_CARDS_LOG, player.getName(), cardNameWithSymbol, player.getScore()));
        }
    }
}
