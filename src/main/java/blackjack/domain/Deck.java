package blackjack.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    private static final String NOT_ENOUGH_DECK_ERR_MSG = "덱에 남아 있는 카드가 없습니다.";
    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public static Deck createRandomDeck() {
        List<Card> entireCards = createEntireCards();
        Collections.shuffle(entireCards);

        return new Deck(entireCards);
    }

    private static List<Card> createEntireCards() {
        return Arrays
            .stream(Denomination.values())
            .flatMap(Deck::createEntireSuitCards)
            .collect(Collectors.toList());
    }

    private static Stream<Card> createEntireSuitCards(Denomination denomination) {
        return Arrays
            .stream(Suit.values())
            .map(suit -> new Card(denomination, suit));
    }

    public Card drawCard() {
        try {
            return cards.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(NOT_ENOUGH_DECK_ERR_MSG);
        }
    }
}
