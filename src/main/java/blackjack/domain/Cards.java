package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public void addCards(List<Card> drawCards) {
        cards.addAll(drawCards);
    }

    public int sumCardScore() {
        return cards.stream()
            .reduce(0, (x, y) -> x + y.calculateScore(x), Integer::sum);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
