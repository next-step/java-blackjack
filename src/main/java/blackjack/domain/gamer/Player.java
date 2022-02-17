package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.matchInfo.MatchResult;
import java.util.List;

public class Player extends Gamer {

    public Player(final String name) {
        super(name);
    }

    public Player(final String name, final List<Card> cards) {
        super(name, cards);
    }

    public MatchResult getMatchResult(final Gamer player, final Gamer dealer) {
        return MatchResult.calcMatchResult(player, dealer);
    }

}
