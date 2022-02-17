package blackjack.domain.gamer;

import blackjack.domain.matchInfo.MatchResult;

public class Player extends Gamer {
    public Player(String name) {
        super(name);
    }

    public MatchResult getMatchResult(Gamer player, Gamer dealer) {
        return MatchResult.calcMatchResult(player, dealer);
    }

}
