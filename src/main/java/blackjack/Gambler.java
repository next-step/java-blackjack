package blackjack;

import java.util.List;

public class Gambler {
    private String name;
    private List<Card> card;

    public Gambler() {
        this("dealer", null);
    }

    public Gambler(String name) {
        this(name, null);
    }

    public Gambler(String name, List<Card> card) {
        this.name = name;
        this.card = card;
    }

    public void drawCard() {
        card.add(new Card());
    }

    public String getName() {
        return name;
    }
}
