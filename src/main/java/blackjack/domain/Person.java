package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;

import java.util.Objects;

public abstract class Person {
    protected final CardBunch cardBunch;
    protected final String name;

    protected Person(String name) {
        this.name = name;
        this.cardBunch = new CardBunch();
    }

    protected Person(String name, CardBunch cardBunch) {
        this.name = name;
        this.cardBunch = cardBunch;
    }

    public abstract boolean canDrawCard();

    public void drawCardFromDeck(Deck deck) {
        cardBunch.addCard(
            deck.drawCard()
        );
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
