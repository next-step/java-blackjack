package blackjack.domain.gameplayer;

import java.util.List;

public class DealerPlayer extends GamePlayer {

    private static final int DEALER_BOUND = 16;
    private static final String WIN = "승";
    private static final String LOSE = "패";

    public DealerPlayer(final String name) {
        super(name);
    }

    @Override
    public boolean isLowerThanBound() {
        return getScore() <= DEALER_BOUND;
    }

    @Override
    public String getGameResult(List<GamePlayer> allPlayers) {
        int winCount = 0;
        int loseCount = 0;

        for (GamePlayer gamePlayer : allPlayers) {
            if (this.getScore() > gamePlayer.getScore()) {
                winCount++;
            }
            loseCount++;
        }
        return getGameResultWord(winCount, loseCount);
    }

    private String getGameResultWord(final int winCount, final int loseCount) {
        final StringBuilder resultWord = new StringBuilder();
        if (winCount > 0) {
            resultWord.append(winCount + WIN);
        }

        if (loseCount > 0) {
            resultWord.append(loseCount + LOSE);
        }

        return resultWord.toString();
    }
}
