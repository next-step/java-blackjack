package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;

import java.util.Objects;
import java.util.stream.IntStream;

public abstract class Person {

    private static final int END_EXCLUSIVE = 2;

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

    public PersonInfo getPersonInfo() {
        return new PersonInfo(
                new NameInfo(name),
                cardBunch.getCardBunchInfo(),
                getScore()
        );
    }

    public void initialCard(Deck deck) {
        IntStream.range(0, END_EXCLUSIVE).forEach(n -> drawCard(deck));
    }

    public void drawCard(Deck deck) {
        cardBunch.drawCard(deck);
    }

    public NameInfo getNameInfo() {
        return new NameInfo(name);
    }

    public Integer getScore() {
        return cardBunch.calcScore();
    }

    abstract public boolean canDraw();

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
