package blackjack.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private static final String WIN = "승";
    private static final String PUSH = "무";
    private static final String LOSE = "패";

    private final Players players;
    private final Dealer dealer;
    private final CardDeck deck;
    private final Map<String, String> playerResults = new HashMap<>();
    private int dealerWin = 0;
    private int dealerPush = 0;
    private int dealerLose = 0;

    public Game(Dealer dealer, Players players, CardDeck deck) {
        this.players = players;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void init() {
        dealer.deal(deck);
        players.deal(deck);
    }

    public void mapResults() {
        for (Player player : players.get()) {
            playerResults.put(player.getName(), judge(player));
        }
    }

    private String judge(Player player) {
        if (player.isBusted() && dealer.isBusted()) {
            dealerLose++;
            return LOSE;
        }

        if (dealer.isBusted()) {
            dealerLose++;
            return WIN;
        }

        if (player.isBusted()) {
            dealerWin++;
            return LOSE;
        }

        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        if (playerScore > dealerScore) {
            dealerLose++;
            return WIN;
        } else if (playerScore < dealerScore) {
            dealerWin++;
            return LOSE;
        }

        dealerPush++;
        return PUSH;

    }

    public Map<String, String> getPlayerResults() {
        return playerResults;
    }

    public String getDealerWin() {
        if (dealerWin > 0) {
            return dealerWin + WIN;
        }
        return "";
    }

    public String getDealerPush() {
        if (dealerPush > 0) {
            return dealerPush + PUSH;
        }
        return "";
    }

    public String getDealerLose() {
        if (dealerLose > 0) {
            return dealerLose + LOSE;
        }
        return "";
    }
}
