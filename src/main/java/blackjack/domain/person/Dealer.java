package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.cards.CardDeck;
import blackjack.domain.cards.DealerCards;
import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private static final int INITIAL_PICK_NUMBER = 2;
    private static final int FIRST_INDEX = 0;

    private final CardDeck cardDeck = new CardDeck();
    private final DealerCards dealerCards;

    public Dealer() {
        this.dealerCards = new DealerCards(getInitialPickedCards());
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

    public DealerCards getDealerCards() {
        return dealerCards;
    }

    public Card getOpenedCard() {
        return dealerCards.getCardByIndex(FIRST_INDEX);
    }
}
