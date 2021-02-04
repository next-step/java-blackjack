package blackjack.domain;

public abstract class Person {
    protected final CardBunch cardBunch;
    protected final String name;

    public Person(String name) {
        this.name = name;
        this.cardBunch = new CardBunch();
    }

    public Person(String name, CardBunch cardBunch) {
        this.name = name;
        this.cardBunch = cardBunch;
    }

    abstract void requestCard(Deck deck);

    public boolean isBust() {
        return cardBunch.calcScore() > 21;
    }
}
