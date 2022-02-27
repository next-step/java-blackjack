package blackjack.domain;

import blackjack.dto.CardInfo;
import java.util.ArrayList;

public class Player extends Person {

    public Player(final String username) {
        this(username, new Cards(new ArrayList<>()));
    }

    public Player(final String userName, final Cards cards) {
        super(userName, cards);
    }

    public Score compareScore(final Dealer dealer) {
        return Score.judge(cards, dealer.cards);
    }

    public int totalScore() {
        return cards.totalScore();
    }

    @Override
    public boolean canDrawCard() {
        return !cards.blackjack() && !cards.isBust();
    }

    @Override
    public CardInfo openCards() {
        return new CardInfo(userName, cards.openCardAll());
    }
}
