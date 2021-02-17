package blackjack.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalResult {

    private final Map<String, String> finalWinner = new HashMap<>();
    private final List<Score> scores = new ArrayList<>();
    private static final Integer THRESHOLD = 21;
    private static final String LOSE = "패";
    private static final String WIN = "승";

    public void calculateFinalResult(Dealer dealer, Gamers gamers) {
        gamers.getGamers()
            .forEach(
                gamer -> finalWinner.put(
                    gamer.getName(),
                    getFinalResult(dealer, gamer)
                ));
    }

    public void calculateGamerScore(Gamers gamers) {
        gamers.getGamers().forEach(
            gamer -> scores.add(
                gamer.getScore()
            ));
    }

    public List<Score> getScores() {
        return scores;
    }

    public Map<String, String> getFinalWinner() {
        return finalWinner;
    }

    private String getFinalResult(Dealer dealer, Gamer gamer) {
        int dealerScore = dealer.getScore().getValue();
        int gamerScore = gamer.getScore().getValue();
        if (dealerScore > THRESHOLD || gamerScore <= THRESHOLD && dealerScore <= gamerScore) {
            dealer.addLoseCount();
            return WIN;
        }
        dealer.addWinCount();
        return LOSE;
    }
}
