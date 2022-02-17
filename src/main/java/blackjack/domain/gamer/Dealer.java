package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import java.util.List;

public class Dealer extends Gamer {

    private static final int DEALER_SUM_LIMIT = 16;
    public Dealer() {
        super("딜러");
    }

    public Dealer(List<Card> cards) {
        super("딜러", cards);
    }

    public boolean getCardOrNot(Dealer dealer) {
        if (dealer.calcScore(dealer) < DEALER_SUM_LIMIT) {
            dealer.addCard(dealer.getCards());
            return true;
        }
        return false;
    }
}
