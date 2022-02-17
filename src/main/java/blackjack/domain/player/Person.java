package blackjack.domain.player;

public abstract class Person {

    private final String name;

    public Person(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
