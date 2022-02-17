package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    private static final int ADDITION_ACE_SCORE = 10;
    private static final int LIMITED_ACE_SCORE = 11;
    private static final int REFERENCE_POINT = 21;
    private static final String CARD_SIZE_ZERO_ERROR = "카드가 존재하지 않습니다.";
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

    public void add(Card drawCard) {
        cards.add(drawCard);
    }

    private boolean hasAce() {
        return cards.stream().anyMatch(Card::isAce);
    }

    public List<String> openCardOne() {
        if (cards.isEmpty()) {
            throw new RuntimeException(CARD_SIZE_ZERO_ERROR);
        }
        return Arrays.asList(cards.get(0).getCardName());
    }

    public List<String> openCardAll() {
        return cards.stream().map(Card::getCardName).collect(Collectors.toList());
    }

    public boolean isBust() {
        return totalScore() > REFERENCE_POINT;
    }

    public boolean blackjack() {
        return totalScore() == REFERENCE_POINT;
    }
}
