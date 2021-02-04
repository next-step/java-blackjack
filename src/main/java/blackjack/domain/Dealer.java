package blackjack.domain;

public class Dealer extends Person {
    public Dealer(String name) {
        super(name);
    }

    public Dealer(String name, CardBunch cardBunch) {
        super(name, cardBunch);
    }

    @Override
    public void requestCard(Deck deck) {
        while (cardBunch.calcScore() < 17) {
            cardBunch.drawCard(deck);
        }
    }
}
