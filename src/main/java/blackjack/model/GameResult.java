package blackjack.model;

import blackjack.view.Output;

import java.util.List;

public class GameResult {
    private static final int HAVE_COUNT = 0;
    private static final String WIN = "승";
    private static final String LOSE = "패";

    public static StringBuilder makeDealerResult(WinningState winningState) {
        StringBuilder stringBuilder = new StringBuilder();
        if (winningState.getWinCount() > HAVE_COUNT) {
            stringBuilder.append(winningState.getWinCount())
                    .append(WIN);
        }
        if (winningState.getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(winningState.getLoseCount())
                    .append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }

    public static StringBuilder makeUserResult(WinningState winningState) {
        StringBuilder stringBuilder = new StringBuilder();

        if (winningState.getWinCount() > HAVE_COUNT) {
            stringBuilder.append(WIN);
        }
        if (winningState.getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }
}
