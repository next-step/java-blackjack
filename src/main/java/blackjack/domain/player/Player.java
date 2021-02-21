package blackjack.domain.player;

import blackjack.domain.Money;
import blackjack.domain.state.State;

public class Player extends Human {
    private PlayerState playerState;
    private State state;

    public Player(final String name, State state) {
        super(name);
        playerState = new PlayerState();
        this.state = state;
    }

    public Integer revenue() {
        return (int) (playerState.getEarningRate() * (double) (playerState.getBettedMoney().getMoney()));
    }

    // Getter
    public boolean getIsWin() {
        return playerState.getIsWin();
    }

    public State getState() {
        return this.state;
    }

    // Setter
    public void setIsWin(boolean isWin) {
        playerState.setIsWin(isWin);
    }

    public void bet(Money bettedMoney) {
        playerState.setBettedMoney(bettedMoney);
    }

    public void setEarningRate(double earningRate) {
        playerState.setEarningRate(earningRate);
    }

}
