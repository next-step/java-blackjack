package blackjack;

import java.util.List;

public class Cards {

    private static final int ADDITION_ACE_SCORE = 10;
    private static final int LIMITED_ACE_SCORE = 11;
    private static final int REFERENCE_POINT = 21;

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int size() {
        return cards.size();
    }

    public int totalScore() {
        int score = cards.stream().mapToInt(Card::getCardScore).sum();

        if (hasAce() && score <= LIMITED_ACE_SCORE) {
            return score + ADDITION_ACE_SCORE;
        }
        return score;
    }

    public boolean isNearTwentyOne() {
        return totalScore() < REFERENCE_POINT;
    }

    public void add(Card drawCard) {
        cards.add(drawCard);
    }

    private boolean hasAce() {
        return cards.stream().anyMatch(Card::isAce);
    }
}
