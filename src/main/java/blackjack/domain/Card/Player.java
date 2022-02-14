package blackjack.domain.Card;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cards;
    private final String name;
    public Player(String name) {
        this.name = name;
        initSetting();
    }

    private void initSetting() {
        List<Card> cards = Cards.getCardList();
        Collections.shuffle(cards);
        this.cards = cards.stream()
            .limit(INIT_CARD_COUNT)
            .collect(Collectors.toList());
        cards.remove(0);
        cards.remove(0);
    }

    public List<Card> getCards() {
        return cards;
    }
}
