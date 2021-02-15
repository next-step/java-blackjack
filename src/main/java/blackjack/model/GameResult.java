package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final int WINNING_CONDITION = 21;
    private static final int BLACKJACK_WINNING_AMOUNT = 2;

    private final Map<Player, Result> result = new HashMap<>();
    private final Players players;

    public GameResult(final Players players) {
        this.players = players;
        this.stand(players);
    }

    public Result getResult(final Player player) {
        return result.get(player);
    }

    public int getWinningCount() {
        return (int) players
                .getPlayers(player -> player.getJob() == Job.GAMER)
                .stream().filter(player -> result.get(player) == Result.WIN || result.get(player) == Result.BLACKJACK)
                .count();
    }

    public int getLoseCount() {
        return (int) players
                .getPlayers(player -> player.getJob() == Job.GAMER)
                .stream().filter(player -> result.get(player) == Result.BLACKJACK || result.get(player) == Result.LOSE)
                .count();
    }

    public int getTieCount() {
        return (int) players
                .getPlayers(player -> player.getJob() == Job.GAMER)
                .stream().filter(player -> result.get(player) == Result.PUSH)
                .count();
    }

    private void stand(final Players players) {
        final Player dealer = players.getDealer();
        players.getPlayers(player -> player.getJob() == Job.GAMER)
                .forEach(gamer -> putGameResult(gamer, dealer));
    }

    private void putGameResult(final Player gamer, final Player dealer) {
        if (gamer.getCardsScore() == WINNING_CONDITION && gamer.getCardStats().getCards().size() == BLACKJACK_WINNING_AMOUNT) {
            result.put(gamer, Result.BLACKJACK);
        } else if (gamer.getCardsScore() > dealer.getCardsScore()) {
            result.put(gamer, Result.WIN);
        } else if (gamer.getCardsScore() > WINNING_CONDITION) {
            result.put(gamer, Result.BUST);
        } else if (gamer.getCardsScore() == dealer.getCardsScore()) {
            result.put(gamer, Result.PUSH);
        } else if (gamer.getCardsScore() < dealer.getCardsScore()) {
            result.put(gamer, Result.LOSE);
        }
    }
}