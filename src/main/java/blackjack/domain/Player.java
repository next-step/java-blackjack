package blackjack.domain;

public class Player extends Person {

    public Player(String name) {
        super(name);
    }

    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
    }

    public void requestCard(Deck deck) {
        cardBunch.drawCard(deck);
    }

    @Override
    public boolean canDraw() {
        return !cardBunch.isBust() && !cardBunch.isBlackJack();
    }

}
