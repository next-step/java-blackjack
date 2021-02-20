package blackjack.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class FinalResult {

    public static final int MINUS = -1;
    public static final double BLACKJACK_RATE = 1.5;
    private static final Integer THRESHOLD = 21;
    private final Map<String, Integer> finalWinner = new LinkedHashMap<>();
    private int moneyOfDealer = 0;

    public int getFinalResult(Dealer dealer, Gamer gamer) {
        int dealerScore = dealer.getScore().getValue();
        int gamerScore = gamer.getScore().getValue();
        int gamerMoney = gamer.getMoney();
        if (dealerScore > THRESHOLD) {
            moneyOfDealer += gamerMoney;
            return gamerMoney * MINUS;
        }
        if (gamerScore == THRESHOLD && dealerScore < THRESHOLD) {
            moneyOfDealer += (int) (gamerMoney * BLACKJACK_RATE);
            return (int) (gamerMoney * MINUS * BLACKJACK_RATE);
        }
        if (gamerScore == THRESHOLD && dealerScore == THRESHOLD) {
            return 0;
        }
        if (gamerScore > dealerScore) {
            moneyOfDealer -= gamerMoney;
            return gamerMoney;
        }
        if (gamerScore == dealerScore) {
            return 0;
        }
        moneyOfDealer += gamerMoney;
        return gamerMoney * MINUS;
    }

    public void calculateFinalWinner(Dealer dealer, Gamers gamers) {
        dealer.calculateScore();
        for (Gamer gamer : gamers.getGamers()) {
            gamer.calculateScore();
            finalWinner.put(gamer.getName(), getFinalResult(dealer, gamer));
        }
    }

    public Map<String, Integer> getFinalWinner() {
        return finalWinner;
    }

    public int getMoneyOfDealer() {
        return moneyOfDealer;
    }
}
