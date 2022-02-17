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
        this.playerScores = new LinkedHashMap<>();
        this.playerResults = new LinkedHashMap<>();
        updatePlayersMap(players);

    }

    private void updatePlayersMap(List<Player> players) {
        players.forEach(player -> {
            playerScores.put(player.getName(), player.calculateScore());
        });
    }

    public Map<String, String> findWinners() {
        int dealerScore = playerScores.get(DEALER);
        playerScores.remove(DEALER);
        playerResults.put(DEALER, "");
        playerScores.forEach((name, score) -> {
            playerResults.put(name, checkWinOrLose(dealerScore, score));
        });
        playerResults.put(DEALER, getDealerResult());
        return Collections.synchronizedMap(new LinkedHashMap<>(playerResults));
    }

    private String checkWinOrLose(int dealerScore, Integer score) {
        if (score > THRESHOLD) {
            return LOSE;
        }
        if (dealerScore > THRESHOLD || dealerScore <= score) {  // 동점이면 플레이어가 이기게 설정
            return WIN;
        }
        return LOSE;
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
