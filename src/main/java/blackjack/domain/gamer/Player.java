package blackjack.domain.gamer;

import blackjack.domain.matchInfo.MatchResult;

public class Player extends Gamer {
    private static final int THRESHOLD = 21;

    public Player(String name) {
        super(name);
    }

    public MatchResult getMatchResult(Player player, Dealer dealer) {
        return MatchResult.calcMatchResult(player, dealer);
    }

    public boolean isBlackJack(Player player) {
        return calcScore(player) == THRESHOLD;
    }

    public boolean isBust(Player player) {
        return calcScore(player) > THRESHOLD;
    }

}
