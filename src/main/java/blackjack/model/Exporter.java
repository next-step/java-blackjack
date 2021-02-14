package blackjack.model;

import java.util.stream.Collectors;

public class Exporter {
    private static final int WINNING_CONDITION = 21;
    private static final String WINNING = "승";
    private static final String LOSE = "패";
    private final Players players;

    public Exporter(final Players players) {
        this.players = players;
    }

    public String initialCardDistribution() {
        final StringBuilder cardDistribution = new StringBuilder();
        final String dealer = players.getPlayerNames(player -> player.getJob() == Job.DEALER);
        final String gamer = players.getPlayerNames(player -> player.getJob() == Job.GAMER);

        cardDistribution.append(String.format("%s와 %s에게 2장을 나누었습니다.", dealer, gamer)).append("\n");
        final String result = players
                .getPlayers(player -> true)
                .stream()
                .map(Player::exportCardStats)
                .collect(Collectors.joining("\n"));
        cardDistribution.append(result);
        return cardDistribution.toString();
    }

    // pobi카드: 2하트, 8스페이드, A클로버
    public String getPlayerCardsStatus(Player player) {
        return String.format("%s카드: %s", player.getName(), player.getCardStats().getCardsName());
    }

    public String getPlayersCardsStatusWithScore() {
        return players
                .getPlayers(player -> true)
                .stream()
                .map(player -> String.format("%s - 결과 : %d", player.exportCardStats(), player.getCardsScore()))
                .collect(Collectors.joining("\n"));
    }

    public String getResult() {
        final Player dealer = players.getPlayers(player -> player.getJob() == Job.DEALER).get(0);
        final StringBuilder gameResult = new StringBuilder();
        int totalCount = players.getPlayers(player -> player.getJob() == Job.GAMER).size();
        int winCount = 0;

        for (final Player gamer : players.getPlayers(player -> player.getJob() == Job.GAMER)) {
            if (gamer.getCardsScore() < WINNING_CONDITION && gamer.getCardsScore() > dealer.getCardsScore()) {
                winCount += 1;
                gameResult.append(String.format("%s: %s", gamer.getName(), WINNING)).append("\n");
                continue;
            }
            gameResult.append(String.format("%s: %s", gamer.getName(), LOSE)).append("\n");
        }

        gameResult.insert(0, String.format("딜러: %d승, %d패\n", totalCount - winCount, winCount));
        return gameResult.toString();
    }
}