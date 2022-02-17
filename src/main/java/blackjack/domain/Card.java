package blackjack.domain;

import java.util.function.IntUnaryOperator;

public class Card {

    private final CardType cardType;
    private final CardValue cardValue;

    Card(CardType cardType, CardValue cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public int calculateScore(int currentScore) {
        return this.cardValue.intUnaryOperator.applyAsInt(currentScore);
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public String getCardTypeName() {
        return cardType.name;
    }

    public String getNumber(){
        return cardValue.number;
    }

    public enum CardType {
        SPADE("스페이드"),
        CLOVER("클로버"),
        HEART("하트"),
        DIAMOND("다이아몬드");

        private final String name;

        CardType(String name) {
            this.name = name;
        }
    }

    public enum CardValue {
        ACE("A", currentScore -> currentScore < 15 ? 11 : 1),
        TWO("2", currentScore -> 2),
        THREE("3", currentScore -> 3),
        FOUR("4", currentScore -> 4),
        FIVE("5", currentScore -> 5),
        SIX("6", currentScore -> 6),
        SEVEN("7", currentScore -> 7),
        EIGHT("8", currentScore -> 8),
        NINE("9", currentScore -> 9),
        TEN("10", currentScore -> 10),
        QUEEN("Q", currentScore -> 10),
        JACK("J", currentScore -> 10),
        KING("K", currentScore -> 10);

        private final String number;
        private final IntUnaryOperator intUnaryOperator;

        CardValue(String number, IntUnaryOperator intUnaryOperator) {
            this.number = number;
            this.intUnaryOperator = intUnaryOperator;
        }

        public boolean isEqualCardValue(Card card){
            return this.equals(card.getCardValue());
        }
    }
}



