package blackjack.domain;

public class Card {

    private final CardType cardType;
    private final CardValue cardValue;

    Card(CardType cardType, CardValue cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    enum CardType {
        SPADE,
        CLOVER,
        HEART,
        DIAMOND
    }

    enum CardValue {
        ACE("A", -1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        QUEEN("Q", 10),
        JACK("J", 10),
        KING("K", 10);

        private final String number;
        private final int score;

        CardValue(String number, int score) {
            this.number = number;
            this.score = score;
        }
    }
}



