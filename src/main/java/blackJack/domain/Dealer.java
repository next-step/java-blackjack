package blackJack.domain;

import java.util.List;

public class Dealer implements User {

    private final Deck deck;
    private final UserName userName;
    private static final String DEALER_DEFAULT_NAME = "dealer";

    private Dealer() {
        this.deck = Deck.create();
        this.userName = UserName.from(DEALER_DEFAULT_NAME);
    }

    public static Dealer create() {
        return new Dealer();
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
}
