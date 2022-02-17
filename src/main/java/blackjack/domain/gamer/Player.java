package blackjack.domain.gamer;

import blackjack.domain.matchInfo.MatchResult;

public class Player extends Gamer {
    private static final int THRESHOLD = 21;

    public Player(String name) {
        super(name);
    }

    public MatchResult getMatchResult(Gamer player, Gamer dealer) {
        return MatchResult.calcMatchResult(player, dealer);
    }

}
