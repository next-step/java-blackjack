package blackjack.domain;

public class Player extends Person {
    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
    }

    public void requestCard(Deck deck) {
        cardBunch.drawCard(deck);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
