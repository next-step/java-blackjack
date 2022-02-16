package blackjack.domain;

import java.util.function.IntUnaryOperator;

public class Card {

    private final CardType cardType;
    private final CardValue cardValue;

    Card(CardType cardType, CardValue cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public int getScore(int currentScore) {
        return this.cardValue.intUnaryOperator.applyAsInt(currentScore);
    }

    enum CardType {
        SPADE,
        CLOVER,
        HEART,
        DIAMOND
    }

    enum CardValue {
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
    }
}



