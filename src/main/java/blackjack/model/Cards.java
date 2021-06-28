package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private static final List<Card> cards = new ArrayList<>();

    static {
        for (Denomination denomination : Denomination.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(denomination, suit));
            }
        }
    }

    public Cards() {
    }

    public static List<Card> getCards() {
        return cards;
    }
}
