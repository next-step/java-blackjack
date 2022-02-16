package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import java.util.List;

public class Dealer extends Person {

    CardDeck cardDeck;

    public Dealer() {
        cardDeck = new CardDeck();
    }

    public List<Card> getPickedCard(int numberOfCards) {
        return cardDeck.pickCards(numberOfCards);
    }
}
