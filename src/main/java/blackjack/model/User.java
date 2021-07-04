package blackjack.model;

import blackjack.model.state.State;

import java.util.List;

public class User implements Player {
    private static final String DO_NOT_INPUT_NULL_MESSAGE = "이름을 입력하지 않으면 생성할 수 없습니다.";

    private final String name;
    private State state;
    private final WinningState winningState = new WinningState();

    public User(String name, State state) {
        this.state = state;
        validateNullInput(name);
        this.name = name;
    }

    private static void validateNullInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(DO_NOT_INPUT_NULL_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
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
