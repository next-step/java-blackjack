package blackJack.domain;

import java.util.List;

public class Player implements User {

    private static final int ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD = 21;

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

    public boolean isCardDraw() {
        return deck.getScore() <= ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD;
    }

    public String convertStatus() {
        return String.format("%s카드: %s", userName.getName(), deck.convertDeckFormat());
    }

    public int getScore() {
        return deck.getScore();
    }
}
