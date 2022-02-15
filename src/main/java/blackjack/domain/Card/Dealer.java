package blackjack.domain.Card;

import java.util.List;

public class Dealer extends Gamer{
    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cards;

    public Dealer() {
        this.cards = initSetting();
    }
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return "딜러";
    }
}
