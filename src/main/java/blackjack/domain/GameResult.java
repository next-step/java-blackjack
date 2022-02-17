package blackjack.domain;

import static blackjack.domain.ResultValue.DRAW;
import static blackjack.domain.ResultValue.LOSE;
import static blackjack.domain.ResultValue.WIN;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {

    private final LinkedHashMap<String, ResultValue> gameStatus;

    private GameResult(LinkedHashMap<String, ResultValue> gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static GameResult calGameResult(Dealer dealer, Players players) {
        LinkedHashMap<String, ResultValue> result = new LinkedHashMap<>();

        players.getPlayers()
            .forEach(player -> result.put(player.getPlayerName(), getPlayerResult(dealer, player)));

        return new GameResult(result);
    }

    private static ResultValue getPlayerResult(Dealer dealer, Player player) {
        OwnCards dealerDeck = dealer.ownCards;
        OwnCards playerDeck = player.ownCards;

        if (playerDeck.isScoreLimit()) {
            return LOSE;
        }

        if (dealerDeck.isScoreLimit()) {
            return WIN;
        }

        if (playerDeck.isBlackJack() && dealerDeck.isBlackJack()) {
            return DRAW;
        }

        if (playerDeck.isBlackJack()) {
            return WIN;
        }

        if (dealerDeck.isBlackJack()) {
            return LOSE;
        }

        if (playerDeck.getTotalScore() == dealerDeck.getTotalScore()) {
            return DRAW;
        }

        if (playerDeck.getTotalScore() > dealerDeck.getTotalScore()) {
            return WIN;
        }

        return LOSE;
    }

    public List<String> getDealerGameResult() {
        return gameStatus
            .values()
            .stream()
            .map(ResultValue::reverseScore)
            .collect(Collectors.groupingBy(group -> group, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .map(m -> m.getValue() + m.getKey().getName())
            .collect(Collectors.toList());
    }

    public List<String> getplayerGameResult() {
        return gameStatus.entrySet().stream()
            .map(player -> player.getKey() + " : " + player.getValue().getName()).collect(
                Collectors.toList());
    }
}
