package blackjack.model.player;

import blackjack.model.card.Card;
import blackjack.model.card.CardBundle;

import java.util.ArrayList;

import static blackjack.utils.StringUtils.COLON;

public abstract class Player {
    protected final CardBundle cardHand;
    protected final String name;

    protected Player(CardBundle cardHand, String name) {
        this.cardHand = cardHand;
        this.name = name;
    }

    protected Player(String name) {
        this.cardHand = CardBundle.of(new ArrayList<>());
        this.name = name;
    }

    public CardBundle getCardHand() {
        return cardHand;
    }

    public String getName() {
        return name;
    }

    public void drawCard(Card card) {
        cardHand.add(card);
    }

    public int getCardHandScore() {
        return cardHand.calculateScore();
    }

    public abstract String getResult();

    @Override
    public String toString() {
        return name + COLON;
    }
}
