package blackjack.domain;

import java.util.List;

public class DealerRecord extends RecordRule {
    private final Dealer dealer;
    private final List<Player> players;
    private int win = 0;
    private int draw = 0;
    private int lose = 0;

    public DealerRecord(final Dealer dealer, final List<Player> players) {
        this.dealer = dealer;
        this.players = players;
        createRecord();
    }

    public void createRecord() {
        int dealerScore = dealer.getResult();
        for (Player player : players) {
            int playerScore = player.getResult();
            winOrLose(dealerScore, playerScore);
        }
    }

    public void winOrLose(int dealerScore, int playerScore) {
        if (playerWin(dealerScore, playerScore)) {
            win++;
            return;
        }
        if (playerDraw(dealerScore, playerScore)) {
            draw++;
            return;
        }
        lose++;
    }

    public int getWin() {
        return win;
    }

    public int getDraw() {
        return draw;
    }

    public int getLose() {
        return lose;
    }
}
