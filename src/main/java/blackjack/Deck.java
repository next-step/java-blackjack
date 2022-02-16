package blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {

    private static final int REMOVE_INDEX = 0;
    private final List<Card> cards;

    public Deck(final List<Card> cards) {
        this.cards = cards;
    }

    public static Deck create() {
        List<Card> cards = createEntireCards();
        Collections.shuffle(cards);
        return new Deck(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new RuntimeException("더 이상 카드를 뽑을 수 없습니다.");
        }
        return cards.remove(REMOVE_INDEX);
    }

    public int deckSize() {
        return cards.size();
    }

    private static List<Card> createEntireCards() {
        return Arrays.stream(CardNumber.values())
            .flatMap(Deck::createEntireSuitCards)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    private static Stream<Card> createEntireSuitCards(final CardNumber cardNumber) {
        return Arrays.stream(Suit.values())
            .map(suit -> new Card(cardNumber, suit));
    }
}
