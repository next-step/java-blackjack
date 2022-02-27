package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cards {

    private final static int BLACKJACK = 21;
    private final List<Card> cards;

    public Cards(final List<Card> cards) {
        this.cards = cards;
    }

    private static int getScoreToSum(final int score, final int compareScore) {
        if ((compareScore == CardNumber.ACE.getScore()) && (score + CardNumber.ACE.getScore()
            > BLACKJACK)) {
            return 1;
        }
        return compareScore;
    }

    public void add(final Card card) {
        cards.add(card);
    }


    public boolean isBust() {
        final int cardSum = sumScore();
        return cardSum > BLACKJACK;
    }

    public boolean isBlackJack() {
        final int cardSum = sumScore();
        return cardSum == BLACKJACK;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotalScore() {
        return sumScore();
    }

    public int sumScore() {
        Comparator<Card> comparator = (a, b) -> b.getCardNumber().getScore() - a.getCardNumber()
            .getScore();

        List<Card> newCards = new ArrayList<>(cards);
        newCards.sort(comparator);

        return newCards.stream()
            .mapToInt(card -> card.getCardNumber().getScore())
            .reduce(0, (a, b) -> a + getScoreToSum(a, b));
    }
}