package blackjack.domain;

import java.util.HashMap;
import java.util.Map;

public class FinalResult {

    private final Map<String, String> finalWinner = new HashMap<>();
    private static final Integer THRESHOLD = 21;
    private static final String LOSE = "패";
    private static final String WIN = "승";
    private int winCount = 0;
    private int loseCount = 0;

    public String getFinalResult(Dealer dealer, Gamer gamer) {
        int dealerScore = dealer.getScore().getValue();
        int gamerScore = gamer.getScore().getValue();
        if ( dealerScore > THRESHOLD || gamerScore <= THRESHOLD && dealerScore <= gamerScore) {
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
            finalWinner.put(gamer.getName(), getFinalResult(dealer, gamer));
        }
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public Map<String, String> getFinalWinner() {
        return finalWinner;
    }
}
