package blackjack.domain;

public class Player {
    private final CardBunch cardBunch;

    public Player() {
        this.cardBunch = new CardBunch();
    }

    public Player(CardBunch cardBunch) {
        this.cardBunch = cardBunch;
    }

    public void requestCard(Deck deck) {
        cardBunch.drawCard(deck);
    }

    public boolean isBust() {
        return cardBunch.calcScore() > 21;
    }
}
