package blackjack.domain.card;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
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
        final Card card =  cards.draw();
        cards.remove(card);
        return card;
    }

    public List<Card> dealInitCards() {
        return IntStream.range(0, NUMBER_OF_INIT_HANDS)
            .mapToObj(i -> draw())
            .collect(Collectors.toList());
    }
}
