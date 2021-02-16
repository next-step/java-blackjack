package blackjack.domain;

import blackjack.dto.PersonMatchProfitInfo;

public class Player extends Person {
    private final int betMoney;

    public Player(String name) {
        super(name);
        this.betMoney = 0;
    }

    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
        this.betMoney = 0;
    }

    public Player(String name, int betMoney) {
        super(name);
        this.betMoney = betMoney;
    }

    public Player(String name, int betMoney, CardBunch cardBunch) {
        super(name, cardBunch);
        this.betMoney = betMoney;
    }

    @Override
    public boolean canDrawCard() {
        return !cardBunch.isBlackJackScore() && !cardBunch.isBust();
    }

    public PersonMatchProfitInfo getPlayerMatchProfitInfo(Dealer dealer) {
        int playerProfit = getMatchProfit(dealer);
        dealer.addProfit(-playerProfit);

        return new PersonMatchProfitInfo(name, playerProfit);
    }

    private Integer getMatchProfit(Person dealer) {
        return (int) (MatchScore.calcDividend(this.cardBunch, dealer.cardBunch) * betMoney);
    }
}
