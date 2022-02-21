package blackJack.domain;

public class CardType {

    private final Suit suit;

    private CardType(String cardType) {
        this.suit = Suit.from(cardType);
    }

    public static CardType from(String cardType) {
        return new CardType(cardType);
    }

    public String getType() {
        return suit.getName();
    }
}
