package blackjack.model;

import blackjack.model.state.State;

import java.util.List;

public class Player implements PlayerFunction {
    private State state;
    private final WinningState winningState = new WinningState();

    protected Player(State state) {
        this.state = state;
    }

    @Override
    public int getCardValueSum() {
        return this.state.getBunchOfCard().getCardValueSum();
    }

    @Override
    public List<String> getCardNames() {
        return this.state.getBunchOfCard().getCardNames();
    }

    @Override
    public WinningState getWinningState() {
        return this.winningState;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void drawCard(Card card) {
        this.state = state.draw(card);
    }

    @Override
    public boolean isBust() {
        return this.state.getBunchOfCard().isBust();
    }
}
