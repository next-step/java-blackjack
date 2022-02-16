package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardPack {

    private final List<Card> cardPack = new ArrayList<>();

    public CardPack() {
        create();
    }

    public void create() {
        for (final CardSymbol symbol : CardSymbol.values()) {
            Arrays.stream(CardType.values())
                .forEach(type -> cardPack.add(new Card(symbol, type)));
        }
        Collections.shuffle(cardPack);
    }

    public List<Card> getCardPack() {
        return Collections.unmodifiableList(cardPack);
    }

    public Card remove() {
        return cardPack.remove(0);
    }
}
