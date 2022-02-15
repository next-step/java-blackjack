package blackjack.domain.person;

import blackjack.domain.card.Card;

public class Dealer extends Person {

    public Dealer(Card card1, Card card2) {
        initTwoCards(card1, card2);
    }
}
