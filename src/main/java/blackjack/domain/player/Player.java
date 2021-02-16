package blackjack.domain.player;

import blackjack.domain.Money;
import blackjack.domain.state.State;

public class Player extends Human {
    // 이 두 개를 PlayerState 는 클래스로
//    private Money bettedMoney;
//    private boolean isWin;

    private PlayerState playerState;
    private State state;

    public Player(final String name, State state) {
        super(name);
        playerState = new PlayerState();
        this.state = state;
    }

    // Setter
    public void setIsWin(boolean isWin) {
        playerState.setIsWin(isWin);
    }

    // Getter
    public boolean getIsWin() {
        return playerState.getIsWin();
    }

    public State getState() {
        return this.state;
    }

    public void bet(Money bettedMoney) {
        playerState.setBettedMoney(bettedMoney);
    }
}
