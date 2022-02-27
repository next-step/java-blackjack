package blackjack.domain.state;

import blackjack.domain.card.Cards;

public class Hit extends Play {

    public Hit(final Cards cards) {
        super(cards);
    }

    @Override
    public Gameable draw() {
        if (cards.isBust()) {
            return new Bust(cards);
        }
        if (cards.isBlackJack()) {
            return new Blackjack(cards);
        }
        return new Hit(cards);
    }

    @Override
    public Gameable stay() {
        return new Stay(cards);
    }
}
