package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;

public class Dealer extends Person {

    CardDeck cardDeck;

    public Dealer() {
        cardDeck = new CardDeck();
    }
}
