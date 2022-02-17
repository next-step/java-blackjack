package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import blackjack.domain.card.Denomination;
import java.util.ArrayList;
import java.util.List;

public class Dealer extends Person {

    private static final int FIRST_INDEX = 0;
    private static final int INITIAL_PICK_NUMBER = 2;
    private static final int DEALER_MAXIMUM_SUM = 16;

    private final CardDeck cardDeck = new CardDeck();

    public Dealer() {
        this.cards.addAll(getInitialPickedCards());
    }

    public List<Card> getInitialPickedCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < INITIAL_PICK_NUMBER; i++) {
            cards.add(cardDeck.pickOneCard());
        }
        return cards;
    }

    public Card getPickedCard() {
        return cardDeck.pickOneCard();
    }

    public Card getOpenedCard() {
        return cards.get(FIRST_INDEX);
    }
}
