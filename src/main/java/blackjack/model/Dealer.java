package blackjack.model;

public class Dealer extends Player{


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
        super.drawCard(card);
    }

}
