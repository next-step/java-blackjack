package blackjack.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    private static final String NOT_ENOUGH_DECK_ERR_MSG = "덱에 남아있는 카드가 없습니다";

    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
        cards = Arrays.stream(
                Denomination.values()
        ).flatMap(
                d -> Arrays.stream(
                        Suit.values()
                ).map(
                        s -> new Card(d, s)
                )
        ).collect(
                Collectors.toList()
        );

        Collections.shuffle(cards);
    }

    public Card drawCard() {
        try {
            return cards.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(NOT_ENOUGH_DECK_ERR_MSG);
        }
    }
}
