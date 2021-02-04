package blackjack.domain;

public class Dealer {
    private final CardBunch cardBunch;

    public Dealer() {
        this.cardBunch = new CardBunch();
    }

    public Dealer(CardBunch cardBunch) {
        this.cardBunch = cardBunch;
    }

    public void requestCard(Deck deck) {
        while (cardBunch.calcScore() < 17) {
            cardBunch.drawCard(deck);
        }
    }

    public boolean isBust() {
        return cardBunch.calcScore() > 21;
    }
}
