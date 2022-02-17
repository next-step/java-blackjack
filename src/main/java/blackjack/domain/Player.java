package blackjack.domain;

public class Player extends Person {

    private final CardAddible cards;

    public Player(final String name, CardAddible cards) {
        super(name);
        this.cards = cards;
    }

    public CardAddible getCards() {
        return cards; //2장 셋팅한 카드
    }
}
