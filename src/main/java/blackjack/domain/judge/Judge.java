package blackjack.domain.judge;

import blackjack.domain.participant.Participant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Judge {

    private static final int LIMIT_SCORE = 21;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DEALER_WIN_OR_LOSE_FORMAT = "%d승 %d패";

    public Map<String, String> getWinOrLose(final Participant dealer, final List<Participant> players) {
        final Map<String, String> result = new LinkedHashMap<>();

        players.forEach(player -> result.put(
            player.getName(),
            getWinOrLosePerPlayer(player.getScore(), dealer.getScore())));

        final int winCount = (int) result.values().stream()
            .filter(v -> v.equals(LOSE))
            .count();

        result.put(dealer.getName(),
            String.format(DEALER_WIN_OR_LOSE_FORMAT, winCount, result.size() - winCount));

        return result;
    }

    private String getWinOrLosePerPlayer(final int playerScore, final int dealerScore) {
        if (playerScore < LIMIT_SCORE && dealerScore > LIMIT_SCORE) {
            return WIN;
        }

        if (playerScore > LIMIT_SCORE || playerScore <= dealerScore) {
            return LOSE;
        }

        return WIN;
    }
}
