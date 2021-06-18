package blackjack.model;

import blackjack.model.state.State;

import java.util.List;

public interface PlayerFunction {
    int getCardValueSum();

    List<String> getCardNames();

    WinningState getWinningState();

    State getState();

    void drawCard(Card card);

    boolean isBust();

    int getWinCount();

    int getDrawCount();

    int getLoseCount();
}
