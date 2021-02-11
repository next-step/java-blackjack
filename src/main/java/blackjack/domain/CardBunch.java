package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardBunch {
    private static final int BLACK_JACK_SCORE = 21;

    private final List<Card> cardBunch;

    public CardBunch() {
        this.cardBunch = new ArrayList<>();
    }

    public CardBunch(List<Integer> score, Suit suit) {
        cardBunch = score
            .stream()
            .map(n -> new Card(Denomination.of(n), suit))
            .collect(Collectors.toList());
    }

    public void addCard(Card card) {
        cardBunch.add(card);
    }

    public boolean isBlackJack() {
        return calcScore() == BLACK_JACK_SCORE;
    }

    public boolean isBust() {
        return calcScore() > BLACK_JACK_SCORE;
    }

    public int calcScore() {
        int score = cardBunch
            .stream()
            .mapToInt(Card::getScore)
            .sum();

        if (hasAce() && score < 12) {
            return score + 10;
        }
        return score;
    }

    private boolean hasAce() {
        return cardBunch.stream().anyMatch(Card::isAce);
    }

    public List<String> getCardsName() {
        return cardBunch
            .stream()
            .map(Card::getCardName)
            .collect(Collectors.toList());
    }
}
