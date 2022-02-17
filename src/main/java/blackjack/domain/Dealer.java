package blackjack.domain;

public class Dealer extends Player {

    private static final int SCORE_THRESHOLD = 16;
    private static final String DEALER = "딜러";
    private static final int TWICE = 2;

    private final Deck deck;

    public Dealer() {
        super(DEALER);
        this.deck = new Deck();
    }

    public void allocateInitialCards(Player player) {
        for (int i = 0; i < TWICE; i++) {
            Card popped = deck.popCard();
            player.receiveCard(popped);
        }
    }

    public void allocateCard(Player player) {
        Card popped = deck.popCard();
        player.receiveCard(popped);

    }

    public boolean addOneMoreCard() {
        int score = calculateScore();
        if (score <= SCORE_THRESHOLD) {
            cards.add(deck.popCard());
            return true;
        }
        return false;
    }


}
