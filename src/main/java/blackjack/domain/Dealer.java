package blackjack.domain;

public class Dealer extends Person {
    public Dealer() {
        super();
    }

    public Dealer(CardBunch cardBunch) {
        super(cardBunch);
    }

    @Override
    public void requestCard(Deck deck) {
        while (cardBunch.calcScore() < 17) {
            cardBunch.drawCard(deck);
        }
    }
}
