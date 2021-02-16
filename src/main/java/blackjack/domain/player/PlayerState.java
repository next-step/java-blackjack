package blackjack.domain.player;

import blackjack.domain.Money;

public class PlayerState {
    private Money bettedMoney;
    private boolean isWin;

    public Money getBettedMoney() {
        return bettedMoney;
    }

    public void setBettedMoney(Money bettedMoney) {
        this.bettedMoney = bettedMoney;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(boolean win) {
        isWin = win;
    }
}
