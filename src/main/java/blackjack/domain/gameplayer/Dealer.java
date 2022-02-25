package blackjack.domain.gameplayer;

import java.util.List;

public class Dealer extends GamePlayer {

    private static final String DEALER = "딜러";
    private static final int DEALER_BOUND = 16;
    private static final String DealerResult = "%d승 %d패";

    public Dealer() {
        this(new Name(DEALER));
    }

    public Dealer(final Name name) {
        super(name);
    }

    @Override
    public boolean isLowerThanBound() {
        return getScore() <= DEALER_BOUND;
    }

    @Override
    public String getGameResult(List<GamePlayer> players) {
        int winCount = 0;
        if (isContinue()) {
            winCount = findWinCount(getScore(), players);
        }
        int loseCount = players.size() - winCount;

        return String.format(DealerResult, winCount, loseCount);
    }

    private int findWinCount(int dealerScore, List<GamePlayer> players) {
        return (int) players.stream()
            .filter(player -> !player.isContinue() || player.getScore() < dealerScore)
            .count();
    }
}
