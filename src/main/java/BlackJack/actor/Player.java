package BlackJack.actor;

public class Player extends CasinoPerson {

    private final int SCORE_LIMIT = 21;
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public boolean isDrawCard(int score) {
        return score < SCORE_LIMIT;
    }

    public boolean compare(Dealer dealer) {
        return !this.bust() && (dealer.bust() || dealer.sumCards() < sumCards());
    }

    public String getPlayerName() {
        return playerName;
    }

}
