package blackjack;

public class Card {
    private CardType cardType;
    private CardValue cardValue;
    private String name;

    public Card(CardType type, CardValue value) {
        this.cardType = type;
        this.cardValue = value;
        this.name = parseCard(cardType, cardValue);
    }

    public String getName() {
        return name;
    }

    public int getScore(){
        return cardValue.getScore();
    }

    private String parseCard(CardType cardType, CardValue cardValue) {
        return cardValue.getTag() + cardType.getType();
    }

    @Override
    public String toString(){
        return name;
    }
}