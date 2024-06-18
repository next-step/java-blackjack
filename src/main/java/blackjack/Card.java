package blackjack;

public class Card {

    private CardNumber number;
    private final CardSuit suit;

    public Card(CardNumber number, CardSuit suit) {
        this.number = number;
        this.suit = suit;
    }

    public Card(Card card) {
        this.number = card.number;
        this.suit  = card.suit;
    }

    public CardNumber getNumber() {
        return number;
    }
    public Integer toInt() {
        return number.getNumber();
    }

    public CardSuit getSuit() {
        return suit;
    }
}
