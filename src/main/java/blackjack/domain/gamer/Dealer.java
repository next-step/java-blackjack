package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import java.util.List;

public class Dealer extends Gamer {
    public Dealer() {
        super("딜러");
    }

    public Dealer(List<Card> cards) {
        super("딜러", cards);
    }
}
