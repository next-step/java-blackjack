package blackjack.domain.player;

import blackjack.domain.state.State;

public class Player extends Human {
    private boolean isWin;
    private State state;

    public Player(final String name, State state) {
        super(name);
        this.state = state;
    }

    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public State getState() {
        return this.state;
    }
}
