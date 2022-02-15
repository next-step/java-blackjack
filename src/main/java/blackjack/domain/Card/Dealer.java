package blackjack.domain.Card;

import java.util.List;

public class Dealer extends Gamer{

    private List<Card> cards;

    public Dealer() {
        this.cards = initSetting();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getPlayerCardSum(Dealer dealer) {
        return dealer.getCards().stream().map(Card::getDenomination)
            .mapToInt(Denomination::getValue).sum();
    }
    @Override
    public String getName() {
        return "딜러";
    }
}
