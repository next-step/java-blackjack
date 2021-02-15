package blackjack.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalResult {

    private final Map<String, String> finalWinner = new HashMap<>();
    private static final Integer THRESHOLD = 21;
    private static final String LOSE = "패";
    private static final String WIN = "승";
    private int winCount = 0;
    private int loseCount = 0;
    private final List<Score> scores = new ArrayList<>();

    public String getFinalResult(Dealer dealer, Gamer gamer) {
        int dealerScore = dealer.getScore().getValue();
        if ( dealerScore > THRESHOLD || dealerScore <= gamer.getScore().getValue()) {
            loseCount++;
            return WIN;
        }
        winCount++;
        return LOSE;
    }

    public void calculateFinalWinner(Dealer dealer, Gamers gamers) {
        dealer.calculateScore();
        for (Gamer gamer : gamers.getGamers()) {
            gamer.calculateScore();
            scores.add(gamer.getScore());
            finalWinner.put(gamer.getName(), getFinalResult(dealer, gamer));
        }
    }

    public List<Score> getScores() {
        return scores;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public Map<String, String> getFinalWinner () {
        return finalWinner;
    }
}
