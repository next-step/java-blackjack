package blackJack.domain;

import blackJack.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> deck;
    private static final String JQK_REGEX = "[JQK]";
    private static final int JQK_SCORE = 10;
    private static final int ACE_BONUS_SCORE = 11;
    private static final int MATCH_SCORE = 21;

    private Deck() {
        this.deck = new ArrayList<>();
    }

    private Deck(List<Card> deck) {
        this.deck = deck;
    }

    public static Deck create() {
        return new Deck();
    }

    public static Deck from(List<Card> deck) {
        return new Deck(deck);
    }

    public void append(Card card) {
        deck.add(card);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public int getScore() {
        int score = 0;
        int count = 0;
        for (Card card : deck) {
            String number = card.getCardNumber().getNumber();
            if (Util.isNumber(number)) {
                score += Integer.parseInt(number);
            }
            if (number.matches(JQK_REGEX)) {
                score += JQK_SCORE;
            }
            if (number.equals("A")) {
                score += 1;
                count += 1;
            }
        }
        return calculateAceScore(score, count);
    }

    private int calculateAceScore(int score, int count) {
        int resultScore = score;
        for (int i = 0; i < count; i++) {
            if (resultScore + (ACE_BONUS_SCORE - 1) > MATCH_SCORE) {
                break;
            }
            resultScore += (ACE_BONUS_SCORE - 1);
        }
        return resultScore;
    }
}
