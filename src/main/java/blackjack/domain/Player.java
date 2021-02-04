package blackjack.domain;

public class Player extends Person {
    public Player(String name) {
        super(name);
    }

    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
    }

    @Override
    public void requestCard(Deck deck) {
        cardBunch.drawCard(deck);
    }
}
