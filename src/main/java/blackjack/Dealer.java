package blackjack;

public class Dealer extends Person {

    private static final int DEALER_DRAW_LIMIT = 16;

    public Dealer(String userName,Cards cards) {
        super(userName,cards);
    }

    @Override
    public boolean canDrawCard() {
        return cards.totalScore() <= DEALER_DRAW_LIMIT;
    }
}
