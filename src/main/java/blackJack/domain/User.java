package blackJack.domain;

import java.util.List;

public abstract class User {

    protected final Deck deck;
    protected final UserName userName;

    protected User(Deck deck, UserName userName) {
        this.deck = deck;
        this.userName = userName;
    }

    public List<Card> getDeck() {
        return deck.getDeck();
    }

    public String getName() {
        return userName.getName();
    }

    public void appendToDeck(Card card) {
        deck.getDeck().add(card);
    }

    public void appendToDeck(List<Card> cards) {
        cards.forEach(card -> deck.getDeck().add(card));
    }

    public String convertStatus() {
        return String.format("%s 카드: %s", userName.getName(), deck.convertDeckFormat());
    }

    public int getScore() {
        return deck.getScore();
    }

    public abstract boolean isCardDraw();
}
