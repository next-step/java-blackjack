package blackjack.domain;

import blackjack.dto.PersonCardsInfo;

public class Player extends Person {
    public Player(String name) {
        super(name);
    }

    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
    }

    @Override
    public boolean canDrawCard() {
        return !cardBunch.isBlackJack() && !cardBunch.isBust();
    }

    public MatchScore getMatchScore(Dealer dealer) {
        return MatchScore.calcMatchScore(
            this.cardBunch,
            dealer.cardBunch
        );
    }
}
