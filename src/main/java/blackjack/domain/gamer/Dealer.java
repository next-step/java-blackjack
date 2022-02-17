package blackjack.domain.gamer;

import blackjack.domain.card.Denomination;
import blackjack.domain.card.Card;
import java.util.List;

public class Dealer extends Gamer{
    private static final int THRESHOLD = 21;

    public Dealer() {
        super("딜러");
    }

    public boolean isBlackJack(Dealer dealer) {
        return calcScore(dealer) == THRESHOLD;
    }

    public boolean isBust(Dealer dealer) {
        return calcScore(dealer) > THRESHOLD;
    }

}
