package blackjack.domain.game;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private static final int NUMBER_OF_INIT_HANDS = 2;

    private final Deck deck;

    public Game() {
        this.deck = new Deck();
    }

    public Card draw() {
        return deck.draw();
    }

    public List<Card> dealCards() {
        return IntStream.range(0, NUMBER_OF_INIT_HANDS)
            .mapToObj(i -> deck.draw())
            .collect(Collectors.toList());
    }
}
