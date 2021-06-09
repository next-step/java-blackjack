package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private static List<Card> cardDeck = new ArrayList<>();

    static {
        for (CardPattern cardPattern : CardPattern.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
                cardDeck.add(new Card(cardPattern, cardNumber));
            }
        }
        Collections.shuffle(cardDeck);
    }

    public static List<Card> getCardDeck() {
        return cardDeck;
    }

    public Card getCard() {
        Card card = cardDeck.get(0);
        cardDeck.remove(0);
        return card;
    }

}
