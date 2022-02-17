package blackjack.domain;

public class Dealer extends GamePlayers {

    private static final String DEALER_NAME = "딜러";
    private final int DEALER_DRAW_LIMIT = 16;

    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(OwnCards ownCards) {
        super(DEALER_NAME, ownCards);
    }

    public boolean isAvailDraw() {
        return ownCards.getTotalScore() <= DEALER_DRAW_LIMIT && !ownCards.isScoreLimit();
    }

}
