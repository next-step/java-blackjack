package blackjack.model;

import java.util.stream.Collectors;

public class Exporter {
    private static final String CARD_DISTRIBUTION_MESSAGE = "%s와 %s에게 2장을 나누었습니다.";
    private static final String CARD_STATUS_SCORE_MESSAGE = "%s - 결과 : %d";
    private static final String DEALER_RESULT_STATUS_MESSAGE = "딜러: %d승, %d패, %d무";
    private static final String GAMER_RESULT_STATUS_MESSAGE = "%s: %s";

    private final Players players;

    public Exporter(final Players players) {
        this.players = players;
    }

    public String initialCardDistribution() {
        final StringBuilder cardDistribution = new StringBuilder();
        final String dealer = players.getPlayerNames(player -> player.getJob() == Job.DEALER);
        final String gamer = players.getPlayerNames(player -> player.getJob() == Job.GAMER);

        cardDistribution.append(String.format(CARD_DISTRIBUTION_MESSAGE, dealer, gamer)).append("\n");
        final String result = players
                .getPlayers(player -> true)
                .stream()
                .map(Player::exportCardStats)
                .collect(Collectors.joining("\n"));
        cardDistribution.append(result);
        return cardDistribution.toString();
    }

    public String getPlayersCardsStatusWithScore() {
        return players
                .getPlayers(player -> true)
                .stream()
                .map(player -> String.format(CARD_STATUS_SCORE_MESSAGE, player.exportCardStats(), player.getTotalScore()))
                .collect(Collectors.joining("\n"));
    }

    public String getResult(final GameResult gameResult) {
        final int dealerWinCount = gameResult.getWinningCount();
        final int dealerLoseCount = gameResult.getLoseCount();
        final int dealerTieCount = gameResult.getTieCount();
        final StringBuilder result = new StringBuilder();

        result.append(String.format(DEALER_RESULT_STATUS_MESSAGE, dealerWinCount, dealerLoseCount, dealerTieCount)).append("\n");
        players
                .getPlayers(player -> player.getJob() == Job.GAMER)
                .stream()
                .map(player -> {
                    final Result playResult = gameResult.getResult(player);
                    final String status = playResult.getStatus();
                    return String.format(GAMER_RESULT_STATUS_MESSAGE, player.getName(), status);
                })
                .forEach(resultStatus -> result.append(resultStatus).append("\n"));

        return result.toString();
    }
}