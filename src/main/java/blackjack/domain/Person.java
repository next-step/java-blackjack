package blackjack.domain;

public abstract class Person {
    protected final CardBunch cardBunch;

    public Person() {
        this.cardBunch = new CardBunch();
    }

    public Person(CardBunch cardBunch) {
        this.cardBunch = cardBunch;
    }

    abstract void requestCard(Deck deck);

    public boolean isBust() {
        return cardBunch.calcScore() > 21;
    }
}
