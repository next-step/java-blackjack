package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pocket {
    private final List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getCardsName() {
        return cards.stream()
                .map(Card::getName)
                .collect(Collectors.joining(", "));
    }
}
