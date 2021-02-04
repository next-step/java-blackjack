package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final String NOT_ENOUGH_DECK_ERR_MSG = "덱에 남아있는 카드가 없습니다";
    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
        // TODO : make it more clear
        cards = new ArrayList<>();
        for (Denomination denomination : Denomination.values()) {
            for(Suit suit : Suit.values()) {
                cards.add(
                    new Card(
                        denomination,
                        suit
                    )
                );
            }
        }

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
