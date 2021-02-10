package blackjack.domain;

public class Gamer extends Player {

    private final String name;

    Gamer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
