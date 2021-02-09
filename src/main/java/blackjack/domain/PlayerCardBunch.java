package blackjack.domain;

import java.util.List;

public class PlayerCardBunch extends CardBunch {
    public PlayerCardBunch() {
        super();
    }

    public PlayerCardBunch(List<Card> cardBunch) {
        super(cardBunch);
    }

    public PlayerCardBunch(List<Integer> score, Suit suit) {
        super(score, suit);
    }

    public boolean canDrawCard() {
        return !isBlackJack() && !isBust();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
