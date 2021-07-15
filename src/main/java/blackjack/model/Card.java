package blackjack.model;

public class Card {
    private final CardTypes cardTypes;

    public Card(CardTypes cardTypes) {
        this.cardTypes = cardTypes;
    }

    public String getName() {
        return cardTypes.getName();
    }

    public int getValue() {
        return cardTypes.getValue();
    }
}
