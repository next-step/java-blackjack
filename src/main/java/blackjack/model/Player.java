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

    @Override
    public int getWinCount() {
        return winningState.getWinCount();
    }

    @Override
    public int getDrawCount() {
        return winningState.getDrawCount();
    }

    @Override
    public int getLoseCount() {
        return winningState.getLoseCount();
    }

    @Override
    public void losing() {
        this.winningState.plusLoseCount();
    }

    @Override
    public void winning() {
        this.winningState.plusWinCount();
    }

    @Override
    public void drawing() {
        this.winningState.plusDrawCount();
    }
}
