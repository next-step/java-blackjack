package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Card {

    private final CardNumber cardNumber;
    private final CardPattern cardPattern;

    public Card(CardNumber cardNumber, CardPattern cardPattern) {
        this.cardNumber = cardNumber;
        this.cardPattern = cardPattern;
    }
    
    @Override
    public String toString() {
        return cardNumber.getName() + cardPattern.getName();
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }
}
