package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardPack {

    private static final int FRONT = 0;
    private static final List<Card> cardPack = create();

    private final List<Card> cards;

    public CardPack() {
        this.cards = shuffle(cardPack);
    }

    private static List<Card> create() {
        final List<Card> cards = new ArrayList<>();
        for (final CardSymbol symbol : CardSymbol.values()) {
            Arrays.stream(CardType.values())
                .forEach(type -> cards.add(new Card(symbol, type)));
        }
        return new ArrayList<>(cards);
    }

    private List<Card> shuffle(List<Card> cards) {
        Collections.shuffle(cards);
        return new ArrayList<>(cards);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public Card pick() {
        return cards.remove(FRONT);
    }
}
