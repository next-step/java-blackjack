package blackjack.domain;

public class Player {

    private final Cards cards;

    public Player(Cards cards) {
        this.cards = cards;
    }

    public void deal(CardDeck deck) {
        hit(deck);
        hit(deck);
    }

    public void hit(CardDeck deck) {
        cards.addCard(deck.popCard());
    }

    public int getScore() {
        return cards.getScore();
    }
}
