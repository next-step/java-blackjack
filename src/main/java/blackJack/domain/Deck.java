package blackJack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    private static final int ACE_BONUS_SCORE = 11;
    public static final int MATCH_SCORE = 21;

    private final List<Card> deck;

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

    public String convertDeckFormat() {
        return deck.stream()
            .map(card -> String.format("%s%s", card.getCardNumber(), card.getCardType()))
            .collect(Collectors.joining(", "));
    }

    public int getScore() {
        int aceCount = calculateAceCount();
        int score = calculateDefaultScore();

        return calculateAceScore(score, aceCount);
    }

    private int calculateAceCount() {
        return (int) deck.stream()
            .filter(Card::isAce)
            .count();
    }

    private int calculateDefaultScore() {
        return deck.stream()
            .mapToInt(Card::getCardScore)
            .sum();
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

    public List<Card> getDeck() {
        return deck;
    }
}
