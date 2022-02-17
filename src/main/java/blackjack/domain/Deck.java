package blackjack.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    private final int TOP_OF_CARDS = 0;
    private final String INVALID_DRAW = "남아있는 카드가 없습니다";
    private final List<Card> cards;

    private Deck(List<Card> cards) {
        this.cards = cards;
    }

    public static Deck createDeck() {
        List<Card> blackJack = makeBlackJackCards();

        Collections.shuffle(blackJack);

        return new Deck(blackJack);
    }

    private static List<Card> makeBlackJackCards() {
        return Arrays.stream(CardNumber.values())
            .flatMap(number ->
                Arrays.stream(CardType.values())
                    .map(type -> new Card(number, type)))
            .collect(Collectors.toList());
    }

    public Card cardDraw() {
        if (cards.isEmpty()) {
            throw new RuntimeException(INVALID_DRAW);
        }

        return cards.remove(TOP_OF_CARDS);
    }

    public List<Card> getCards() {
        return cards;
    }
}
