package blackjack.domain;

public class Player extends Person {
    public Player() {
        super();
    }

    public Player(CardBunch cardBunch) {
        super(cardBunch);
    }

    @Override
    public void requestCard(Deck deck) {
        cardBunch.drawCard(deck);
    }
}
