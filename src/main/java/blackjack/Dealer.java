package blackjack;

public class Dealer extends Person {

    public Dealer(String userName,Cards cards) {
        super(userName,cards);
    }

    @Override
    public Card drawCard() {
        return null;
    }
}
