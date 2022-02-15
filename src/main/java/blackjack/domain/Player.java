package blackjack.domain;

public class Player {

    private final Cards cards;

    public Player(Cards cards) {
        this.cards = cards;
    }

    public void deal(CardDeck deck) {
        cards.addCard(deck.popCard());
        cards.addCard(deck.popCard());
    }
}
