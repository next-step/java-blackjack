package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private static final int BLACK_JACK = 21;

    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void receiveCard(final Card card) {
        cards.add(card);
    }

    public List<Card> toList() {
        return Collections.unmodifiableList(cards);
    }

    public int calculateCards() {
        final int sumOfCards = getSumOfCards();
        final int aceCount = getAceCount();

        if (sumOfCards > BLACK_JACK && aceCount > 0) {
            return getBestSumWithAce(sumOfCards);
        }
        return sumOfCards;
    }

    private int getAceCount() {
        return (int) cards.stream()
            .filter(card -> card.getCardType().isAce())
            .count();
    }

    private int getSumOfCards() {
        return cards.stream()
            .map(Card::getCardType)
            .mapToInt(CardType::getPoint)
            .sum();
    }

    private int getBestSumWithAce(final int sum) {
        final int lowerAcePoint = CardType.ACE.getLowerAcePoint();
        final int higherAcePoint = CardType.ACE.getPoint();

        int aceCount = getAceCount();
        int totalPoint = sum;

        while (aceCount > 0 && totalPoint > BLACK_JACK) {
            totalPoint = totalPoint - higherAcePoint + lowerAcePoint;
            aceCount--;
        }
        return totalPoint;
    }
}
