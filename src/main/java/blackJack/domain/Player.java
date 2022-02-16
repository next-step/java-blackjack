package blackJack.domain;

import java.util.List;

public class Player implements User {

    private final Deck deck;
    private final UserName userName;

    private Player(String userName) {
        this.deck = Deck.create();
        this.userName = UserName.from(userName);
    }

    public static Player of(String userName) {
        return new Player(userName);
    }

    public List<Card> getDeck() {
        return deck.getDeck();
    }

    public String getName() {
        return userName.getName();
    }

    public void appendToDeck(Card card) {
        deck.append(card);
    }

    public void appendToDeck(List<Card> cards) {
        cards.forEach(deck::append);
    }
}
