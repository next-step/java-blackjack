package blackjack.view;

import blackjack.domain.gameplayer.GamePlayer;
import blackjack.domain.gameplayer.GamePlayers;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String GAME_INITIAL_MANAGER = "%s에게 2장의 카드를 나누었습니다.";
    private static final String COMMA = ", ";
    private static final String CARDS_LOG = "%s: %s";
    private static final String DEALER_RECEIVE_ONE_CARD_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String RESULT_CARDS_LOG = "%s카드: %s - 결과: %d";
    private static final String RESULT_GAME_LOG = "%s: %s";

    public static void printInitialMessage(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        String playerNames = players.stream()
            .map(GamePlayer::getName)
            .collect(Collectors.joining(COMMA));

        System.out.println(ENTER + String.format(GAME_INITIAL_MANAGER, playerNames));
    }

    public static void printCardAllStatus(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        players.stream()
                .forEach(player -> System.out.println(String.format(CARDS_LOG, player.getName(), getPlayerCardStatus(player))));
        System.out.println();
    }

    public static void printCardStatus(GamePlayer player) {
        System.out.println(String.format(CARDS_LOG, player.getName(), getPlayerCardStatus(player)));
    }

    public static void printDealerAcceptCard() {
        System.out.println(DEALER_RECEIVE_ONE_CARD_MESSAGE);
    }

    public static void printCardResult(GamePlayers gamePlayers) {
        System.out.println();
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        for (GamePlayer player : players) {
            System.out.println(String.format(RESULT_CARDS_LOG, player.getName(), getPlayerCardStatus(player), player.getScore()));
        }
        System.out.println();
    }

    private static String getPlayerCardStatus(GamePlayer gamePlayer) {
        return gamePlayer.getCards().stream()
            .map(card -> card.getCardType().getName() + card.getCardSymbol().getSymbol())
            .collect(Collectors.joining(COMMA));
    }

    public static void printGameResult(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();
        for (GamePlayer player : players) {
            System.out.println(String.format(RESULT_GAME_LOG, player.getName(), player.getGameResult(players)));
        }
    }
}
