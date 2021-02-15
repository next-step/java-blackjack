package blackjack.model;

import java.util.ArrayList;
import java.util.List;

import static blackjack.utils.StringUtils.COLON;

public class Player {

    protected final CardBundle cardHand;
    protected final String name;

    public Player(CardBundle cardHand, String name) {
        this.cardHand = cardHand;
        this.name = name;
    }

    public Player(String name) {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(COLON);
        cardHand.getCards().forEach(card -> stringBuilder.append(card.toString()));
        return stringBuilder.toString();
    }
}
