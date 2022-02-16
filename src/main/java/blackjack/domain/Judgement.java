package blackjack.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Judgement {

    private static final String DEALER = "딜러";
    private static final int THRESHOLD = 21;
    private static final String WIN = "승";
    private static final String LOSE = "패";

    private Map<String, Integer> playerScores;
    private Map<String, String> playerResults;

    public Judgement(List<Player> players) {
        this.players = players;
    }

    public List<String> findWinners() {
        int max = findMaxScore();
        return players.stream().filter(player -> player.calculateScore() == max)
            .map(Player::getName)
            .collect(Collectors.toList());
    }

    private String getDealerResult() {
        long winCount = getCount(LOSE);
        long loseCount = getCount(WIN);
        return winCount + WIN + " " + loseCount + LOSE;
    }

    private long getCount(String indicator) {
        return playerResults.values().stream()
            .filter(result -> Objects.equals(result, indicator)).count();
    }
}
