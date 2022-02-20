package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cards {

    private static final String EMPTY_DECK_EXCEPTION_MESSAGE = "[ERROR] 덱에 남은 카드가 없습니다.";
    private static final int SELECTED_CARD = 0;

    private final List<Card> cards;

    public Cards() {
        this(Arrays.stream(Pattern.values())
            .flatMap(Cards::makeCardsByPattern)
            .collect(Collectors.toList()));
    }

    private static Stream<Card> makeCardsByPattern(Pattern pattern) {
        return Arrays.stream(Rank.values())
            .map(rank -> new Card(pattern, rank))
            .collect(Collectors.toList()).stream();
    }

    private Cards(final List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Card draw() {
        checkDeckIsEmpty();
        Collections.shuffle(cards);
        return cards.get(SELECTED_CARD);
    }

    private void checkDeckIsEmpty() {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_DECK_EXCEPTION_MESSAGE);
        }
    }

    public Cards remove(final Card card) {
        cards.remove(card);
        return new Cards(cards);
    }
}
