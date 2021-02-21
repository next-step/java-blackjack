package blackjack.domain.player;

import blackjack.domain.Money;

public class BettingMoney {
    private Money bettedMoney;
    private double earningRate;

    public BettingMoney(Money bettedMoney){
        this.bettedMoney = bettedMoney;
    }
    public Money getBettedMoney() {
        return bettedMoney;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void setEarningRate(double earningRate) {
        this.earningRate = earningRate;
    }

}
