package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pocket {
    private final List<Card> cards = new ArrayList<>();
    private static final int ACE_PLUS_SCORE_BOUNDARY = 11;
    private static final int ACE_PLUS_SCORE = 10;
    private static final int EMPTY_SIZE = 0;

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getCardsName() {
        if (cards.size() == EMPTY_SIZE) {
            throw new IllegalStateException("포켓에 카드가 없는 상태입니다.");
        }
        return cards.stream()
                .map(Card::getName)
                .collect(Collectors.joining(", "));
    }

    public int getTotalScore(){
        int totalScore = cards
                .stream()
                .mapToInt(Card::getScore)
                .sum();

        if (hasAce() && totalScore <= ACE_PLUS_SCORE_BOUNDARY) {
            totalScore += ACE_PLUS_SCORE;
        }

        return totalScore;
    }

    public boolean hasAce() {
        return cards
                .stream()
                .anyMatch(card -> card.getValue() == CardValue.ACE);
    }
}
