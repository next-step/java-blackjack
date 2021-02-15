package blackjack.domain;

public class Player extends Person {
    private final Integer betMoney;

    public Player(String name) {
        super(name);
        this.betMoney = 0;
    }

    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
        this.betMoney = 0;
    }

    public Player(String name, Integer betMoney) {
        super(name);
        this.betMoney = betMoney;
    }

    public Player(String name, Integer betMoney, CardBunch cardBunch) {
        super(name, cardBunch);
        this.betMoney = betMoney;
    }

    @Override
    public boolean canDrawCard() {
        return !cardBunch.isBlackJackScore() && !cardBunch.isBust();
    }

    public Integer getMatchProfit(Dealer dealer) {
        return (int) (getMatchScore(dealer).getDividend() * betMoney);
    }

    public MatchScore getMatchScore(Dealer dealer) {
        return MatchScore.calcMatchScore(
            this.cardBunch,
            dealer.cardBunch
        );
    }
}
