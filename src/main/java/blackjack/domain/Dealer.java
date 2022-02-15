package blackjack.domain;

public class Dealer extends Player {

    private static final String DEALER = "딜러";

    private final Deck deck;
    public Dealer() {
        super(DEALER);
        this.deck= new Deck();
    }

    public void allocateCard(Player player) {
        Card popped = deck.popCard();
        player.receiveCard (popped);
    }

}
