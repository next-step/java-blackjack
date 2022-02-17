package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final List<Card> ownCards;

    public OwnCards() {
        this.ownCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        ownCards.add(card);
    }

    public List<Card> getOwnCards() {
        return ownCards;
    }
}
