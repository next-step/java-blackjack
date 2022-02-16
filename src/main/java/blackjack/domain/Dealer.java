package blackjack.domain;

public class Dealer extends Player {

    private static final int SCORE_THRESHOLD = 16;
    private static final String DEALER = "딜러";

    private final Deck deck;

    public Dealer() {
        super(DEALER);
        this.deck = new Deck();
    }

    public void allocateCard(Player player) {
        Card popped = deck.popCard();
        player.receiveCard(popped);
    }

    public void addOneMoreCard() {
        int score = calculateScore();
        if (score <= SCORE_THRESHOLD) {
            cards.add(deck.popCard());
        }
    }


}
