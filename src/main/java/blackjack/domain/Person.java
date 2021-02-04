package blackjack.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cardBunch, person.cardBunch) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardBunch, name);
    }
}
