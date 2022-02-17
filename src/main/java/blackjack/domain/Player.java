package blackjack.domain;

public class Player extends GamePlayers {

    private final int DEALER_DRAW_LIMIT = 21;

    public Player(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isAvailDraw() {
        return ownCards.getTotalScore() <= DEALER_DRAW_LIMIT && !ownCards.isScoreLimit();
    }
}
