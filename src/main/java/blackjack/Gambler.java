package blackjack;

import java.util.List;

public class Gambler {
    String name;
    List<Card> card;

    public Gambler() {
        this("dealer");
    }

    public Gambler(String name) {
        this.name = name;
    }

    public void drawCard() {
        card.add(new Card());
    }
}
