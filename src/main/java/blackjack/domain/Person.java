package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;

import java.util.Objects;

public class Person {
    private static String DEALER_NAME = "딜러";

    protected final CardBunch cardBunch;
    protected final String name;

    private Person(String name, CardBunch cardBunch) {
        this.name = name;
        this.cardBunch = cardBunch;
    }

    public static Person createDealer(CardBunch cardBunch) {
        return new Person(DEALER_NAME, cardBunch);
    }

    public static Person createDealer() {
        return new Person(DEALER_NAME, new DealerCardBunch());
    }

    public static Person createPlayer(String name, CardBunch cardBunch) {
        return new Person(name, cardBunch);
    }

    public static Person createPlayer(String name) {
       return new Person(name, new PlayerCardBunch());
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
