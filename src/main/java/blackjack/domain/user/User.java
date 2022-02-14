package blackjack.domain.user;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected final List<Card> cards;

    protected User() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
}
