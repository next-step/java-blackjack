package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardPack {

    private static final int FRONT = 0;

    private final List<Card> cardPack;

    private CardPack(List<Card> cardPack) {
        this.cardPack = cardPack;
    }

    public static CardPack create() {
        final List<Card> cards = new ArrayList<>();
        for (final CardSymbol symbol : CardSymbol.values()) {
            Arrays.stream(CardType.values())
                .forEach(type -> cards.add(new Card(symbol, type)));
        }
        Collections.shuffle(cards);
        return new CardPack(new ArrayList<>(cards));
    }

    public List<Card> getCardPack() {
        return Collections.unmodifiableList(cardPack);
    }

    public Card pick() {
        return cardPack.remove(FRONT);
    }
}
