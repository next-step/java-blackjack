package blackjack.domain;

public class Dealer extends Person{

    private final CardAddible cards;


    public Dealer(String name, CardAddible cards) {
        super(name);
        this.cards = cards;
    }

    /**
     *
     * 17(dealer), 21(player) 이하이면 cards.add(dealer.pop)
     * 17(dealer), 21(player) 이상이면 cards.stay()
     * 공통으로 Dealer, Player
     * @return 황인규
     */

    public CardAddible getCards() {
        return cards;
    }

}
