package blackjack.domain.judge;

import blackjack.domain.participant.Participant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Judge {

    private static final int LIMIT_SCORE = 21;
    private static final String PLAYER_WIN = "승";
    private static final String PLAYER_LOSE = "패";
    private static final String DEALER_WIN_OR_LOSE_FORMAT = "%d승 %d패";

    public Map<String, String> getWinOrLose(final Participant dealer, final List<Participant> players) {
        final Map<String, String> winOrLose = new LinkedHashMap<>();

        players.forEach(player -> winOrLose.put(
            player.getName(),
            getWinOrLosePerPlayer(player.getScore(), dealer.getScore())));

        final int dealerWinCount = getDealerWinCount(winOrLose);
        winOrLose.put(dealer.getName(),
            String.format(DEALER_WIN_OR_LOSE_FORMAT,
                    dealerWinCount, getDealerLoseCount(winOrLose, dealerWinCount)));

        return winOrLose;
    }

    private String getWinOrLosePerPlayer(final int playerScore, final int dealerScore) {
        if (playerScore < LIMIT_SCORE && dealerScore > LIMIT_SCORE) {
            return PLAYER_WIN;
        }
        if (playerScore > LIMIT_SCORE || playerScore <= dealerScore) {
            return PLAYER_LOSE;
        }

        return PLAYER_WIN;
    }

    private int getDealerWinCount(Map<String, String> result) {
        return (int) result.values().stream()
                .filter(v -> v.equals(PLAYER_LOSE))
                .count();
    }

    private int getDealerLoseCount(Map<String, String> winOrLose, int dealerWinCount) {
        return winOrLose.size() - dealerWinCount;
    }
}
