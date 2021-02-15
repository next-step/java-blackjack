package blackjack.domain.player;

import blackjack.domain.state.State;

public class Player extends Human {
    private boolean isWin;
    private State state;

    public Player(final String name, State state) {
        super(name);
        this.state = state;
    }

    // Setter
    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }

    // Getter
    public boolean getIsWin() {
        return isWin;
    }

    public State getState() {
        return this.state;
    }
}
