package blackjack.domain.card;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private static final int NUMBER_OF_INIT_HANDS = 2;

    private final Cards cards;

    public Deck() {
        this.cards = new Cards();
    }

    public Card draw() {
        return cards.draw();
    }

    public List<Card> dealCards() {
        return IntStream.range(0, NUMBER_OF_INIT_HANDS)
            .mapToObj(i -> draw())
            .collect(Collectors.toList());
    }
}
