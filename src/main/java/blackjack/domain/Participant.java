package blackjack.domain;

import static blackjack.utils.Constant.BUST_LIMIT;

import java.util.List;

public class Participant {

    private final Cards cards;

    public Participant(Cards cards) {
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

    public boolean isBusted() {
        return getScore() > BUST_LIMIT;
    }

    public List<String> getCardNames() {
        return cards.getCardNames();
    }

    public String getAllCards() {
        return String.join(", ", getCardNames());
    }
}
