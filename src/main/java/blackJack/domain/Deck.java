package blackJack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    private final List<Card> deck;
    private static final int ACE_BONUS_SCORE = 11;
    public static final int MATCH_SCORE = 21;

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
        int aceCount = calculateAceCount();
        int score = calculateDefaultScore();

        return calculateAceScore(score, aceCount);
    }

    public String convertDeckFormat() {
        return deck.stream()
            .map(card -> String.format("%s%s", card.getCardNumber(), card.getCardType()))
            .collect(Collectors.joining(", "));
    }

    private int calculateDefaultScore() {
        return deck.stream()
            .mapToInt(Card::calculateCardScore)
            .sum();
    }

    private int calculateAceCount() {
        return (int) deck.stream()
            .filter(card -> "A".equals(card.getCardNumber()))
            .count();
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
