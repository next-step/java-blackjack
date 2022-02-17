package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Gamer {

    private static final int INIT_CARD_COUNT = 2;
    private List<Card> cardsAll = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public void match() {

    }

    public List<Card> initSetting() {
        cardsAll = Cards.getCardList();
        Collections.shuffle(cardsAll);
        this.cards = cardsAll.stream()
            .limit(INIT_CARD_COUNT)
            .collect(Collectors.toList());
        cardsAll.remove(0);
        cardsAll.remove(0);
        return this.cards;
    }

    public List<Card> addCard(List<Card> cards) {
        cards.add(cardsAll.get(0));
        cardsAll.remove(0);
        return cards;
    }

    public abstract String getName();
}
