package blackjack.domain;

public class Dealer extends Person{

    private final CardAddible cards;

    public Dealer(String name, CardAddible cards) {
        super(name);
        this.cards = cards;
    }

    public CardAddible getCards() {
        return cards;
    }
}
