package blackjack.domain.Card;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Gamer {

    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cards;
    private String name;
    public List<Card> initSetting() {
        List<Card> cards = Cards.getCardList();
        Collections.shuffle(cards);
        this.cards = cards.stream()
            .limit(INIT_CARD_COUNT)
            .collect(Collectors.toList());
        cards.remove(0);
        cards.remove(0);
        return this.cards;
    }

    public abstract String getName();
}
