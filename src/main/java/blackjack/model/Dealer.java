package blackjack.model;

import blackjack.model.state.State;

import java.util.List;

public class Dealer implements Player {
    private static final int FIRST_CARD_INDEX = 0;
    private static final String DEALER_NAME = "딜러";

    private State state;
    private final WinningState winningState = new WinningState();

    public Dealer(State state) {
        this.state = state;
    }

    public String getFirstCard() {
        return getCardNames().get(FIRST_CARD_INDEX);
    }

    public String getName() {
        return DEALER_NAME;
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
