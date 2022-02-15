package blackjack.domain;

public class Dealer {
    private final CardAddible cards;

    public Dealer(CardAddible cards) {
        this.cards = cards;
    }

    public CardAddible getCards() {
        return cards;
    }
}
