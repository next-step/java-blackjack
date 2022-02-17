package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.matchInfo.MatchResult;
import java.util.List;

public class Player extends Gamer {

    public Player(List<Card> cards) {
        super(cards);
    }
    public Player(String name) {
        super(name);
    }

    public Player(String name, List<Card> cards) {
        super(name, cards);
    }

    public MatchResult getMatchResult(Gamer player, Gamer dealer) {
        return MatchResult.calcMatchResult(player, dealer);
    }

}
