package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import java.util.List;

public class Dealer extends Person {

    private static final int FIRST_INDEX = 0;
    private final CardDeck cardDeck = new CardDeck();

    public Dealer() {
        this.cards.addAll(getPickedCard(2));
    }

    public List<Card> getPickedCard(int numberOfCards) {
        return cardDeck.pickCards(numberOfCards);
    }

    public Card getOpenedCard() {
        return cards.get(FIRST_INDEX);
    }
}
