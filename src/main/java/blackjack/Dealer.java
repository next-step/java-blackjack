package blackjack;

public class Dealer extends Person {

    public Dealer(String userName,Cards cards) {
        super(userName,cards);
    }

    @Override
    public boolean canDrawCard() {
        return cards.isNearTwentyOne();
    }
}
