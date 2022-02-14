package blackjack.domain.user;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Card> cards;
    private final String name;

    public Player(String name) {
        validateName(name);
        this.cards = new ArrayList<>();
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public String name() {
        return name;
    }
}
