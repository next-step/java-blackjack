package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public abstract class CardAddibleSupport implements Gameable {

    Cards cards;

    public CardAddibleSupport(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }
}
