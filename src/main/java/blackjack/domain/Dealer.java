package blackjack.domain;

import blackjack.dto.CardInfo;
import blackjack.dto.MatchInfo;
import java.util.ArrayList;

public class Dealer extends Person {

    public static final int DEALER_DRAW_LIMIT = 16;
    private static final String DEALER_NAME = "딜러";

    public Dealer(String userName, Cards cards) {
        super(userName, cards);
    }

    public Dealer() {
        this(DEALER_NAME, new Cards(new ArrayList<>()));
    }

    @Override
    public boolean canDrawCard() {
        return cards.totalScore() <= DEALER_DRAW_LIMIT;
    }

    @Override
    public CardInfo openCards() {
        return new CardInfo(userName,cards.openCardOne());
    }

}
