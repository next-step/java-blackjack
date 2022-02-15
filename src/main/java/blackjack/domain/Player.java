package blackjack.domain;

public class Player extends Person {

    private final String name;

    public Player(String name, Card card1, Card card2) {
        this.name = name;
        initTwoCards(card1, card2);
    }
}
