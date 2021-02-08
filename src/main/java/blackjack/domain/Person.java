package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;

import java.util.Objects;

public abstract class Person {
    private static final Integer BUST_LIMIT = 21;
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
        return cardBunch.calcScore() > BUST_LIMIT;
    }

    public PersonInfo getPersonInfo() {
        return new PersonInfo(
            new NameInfo(name),
            cardBunch.getCardBunchInfo()
        );
    }

    public NameInfo getNameInfo() {
        return new NameInfo(name);
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
