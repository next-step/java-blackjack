package blackjack.model;

public class Dealer extends Player{

    private static final int UPPER_BOUND_TO_DRAW = 16;

    private Dealer(CardBundle cardHand, String name) {
        super(cardHand, name);
    }

    public Dealer(String name) {
        super(name);
    }

    public static Dealer of(CardBundle cardHand, String name) {
        return new Dealer(cardHand,name);
    }

    public static Dealer of(String name) {
        return new Dealer(name);
    }

    @Override
    public void drawCard(Card card) {
        if (cardHand.calculateScore() <= UPPER_BOUND_TO_DRAW) {
            super.drawCard(card);
        }
    }

}
