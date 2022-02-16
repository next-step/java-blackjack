package blackjack.domain;

import java.util.ArrayList;

public class Dealer extends Participant {
    private static final String NAME_TAG = "딜러 카드: ";
    private static final int LIMIT_MORE_CARD = 16;

    public Dealer(Cards cards) {
        super(cards);
    }

    public static Dealer create() {
        Cards cards = new Cards(new ArrayList<>());
        return new Dealer(cards);
    }

    public boolean checkHitOrNot() {
        return getScore() <= LIMIT_MORE_CARD;
    }

    public String openOneCard() {
        return getCardNames().get(0);
    }
}
