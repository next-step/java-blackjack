package blackjack.domain;

public class Dealer extends Player {
    private static final int LIMIT_MORE_CARD = 16;

    public Dealer(Cards cards) {
        super(cards);
    }

    public boolean checkHitOrNot() {
        return getScore() <= LIMIT_MORE_CARD;
    }

}
