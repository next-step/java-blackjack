package blackjack.domain;

import blackjack.domain.player.Player;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final int BLACKJACK = 21;
    private final Game game;

    public Winner(final Game game) {
        this.game = game;
    }

    public List<Integer> calculateDealerGameResult() {
        int dealerScore = game.getDealer().getCards().cards().sumScore();
        return calculateGameResult(dealerScore);
    }

    public List<Integer> calculatePlayerGameResult(final Player player) {
        int playerScore = player.getCards().cards().sumScore();
        return calculateGameResult(playerScore);
    }

    private List<Integer> calculateGameResult(final int sourceScore) {
        List<Integer> targetScores = game.getScoresOfPlayers().stream()
            .map(this::convertZeroScore)
            .collect(Collectors.toList());
        return Arrays.asList(countWin(sourceScore, targetScores),
            countLose(sourceScore, targetScores));
    }

    private int convertZeroScore(final int score) {
        if (score > BLACKJACK) {
            return 0;
        }
        return score;
    }

    private int countWin(final int sourceScore, final List<Integer> targetScores) {
        if (sourceScore > BLACKJACK) {
            return 0;
        }
        return Long.valueOf(targetScores.stream()
            .filter(targetScore -> sourceScore > targetScore).count()).intValue();
    }

    private int countLose(final int sourceScore, final List<Integer> targetScores) {
        if (sourceScore > BLACKJACK) {
            return targetScores.size();
        }
        return Long.valueOf(targetScores.stream()
            .filter(targetScore -> sourceScore < targetScore).count()).intValue();
    }
}