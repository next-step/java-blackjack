package blackjack.model.state;

import blackjack.model.BunchOfCard;
import blackjack.model.Card;

public class Hit extends Running {
    public Hit(BunchOfCard bunchOfCard) {
        super(bunchOfCard);
    }

    @Override
    public State draw(Card card) {
        bunchOfCard.addCard(card);
        if (bunchOfCard.isBust()) {
            return new Bust(bunchOfCard);
        }
        return new Hit(bunchOfCard);
    }

    @Override
    public State stay() {
        return new Stay(bunchOfCard);
    }
}
