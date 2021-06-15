package BlackJack.actor;

public class Dealer extends CasinoPerson {
    private final String DEALER_NAME = "딜러";
    private final int DEALER_SCORE_LIMIT = 16;
    @Override
    public boolean isDrawCard(int score) {
        return score <= DEALER_SCORE_LIMIT;
    }

    public boolean countWinLose(Player player) {
       return player.compare(this);
    }

    public String getDEALER_NAME() {
        return DEALER_NAME;
    }
}
