package blackjack.domain.player;

import blackjack.domain.Money;

public class PlayerState {
    private BettingMoney bettingMoney;
    private boolean isWin;

    public Money getBettedMoney() {
        return bettingMoney.getBettedMoney();
    }

    public void setBettedMoney(Money bettedMoney) {
        bettingMoney = new BettingMoney(bettedMoney);
    }

    public boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(boolean win) {
        isWin = win;
    }

    public double getEarningRate(){
        return bettingMoney.getEarningRate();
    }

    public void setEarningRate(double earningRate){
        bettingMoney.setEarningRate(earningRate);
    }
}
