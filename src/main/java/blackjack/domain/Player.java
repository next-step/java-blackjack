package blackjack.domain;


public class Player {

    private final Cards cards;
    protected Score score;

    public Player(Deck deck) {
        cards = new Cards();
        init(deck);
    }

    private void init(Deck deck) {
        addCard(deck.popCard());
        addCard(deck.popCard());
    }

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public void calculateScore() {
        score = cards.getScore();
    }

    public Score getScore() {
        return score;
    }

    public Cards getCards() {
        return cards;
    }
}
