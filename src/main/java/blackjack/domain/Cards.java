package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cards {

    private static final int BLACK_JACK = 21;
    private static final int LOSE = 22;

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
        final int aceCount = (int) cards.stream()
            .map(Card::getCardType)
            .map(CardType::isAce)
            .count();

        if (aceCount == 0) {
            return getPointExceptAce();
        }
        return getBestPointWithAce(aceCount);
    }

    private int getPointExceptAce() {
        return cards.stream()
            .map(Card::getCardType)
            .mapToInt(CardType::getPoint)
            .sum();
    }

    private int getBestPointWithAce(final int aceCount) {
        final List<Integer> sums = new ArrayList<>();
        final int sumNotAce = cards.stream()
            .map(Card::getCardType)
            .filter(type -> !type.isAce())
            .mapToInt(CardType::getPoint)
            .sum();

        for (final int possibleSum : getSumsAce(aceCount)) {
            sums.add(sumNotAce + possibleSum);
        }
        return getMaxPoint(sums);
    }

    private List<Integer> getSumsAce(final int aceCount) {
        int lowerPoint = CardType.ACE.getPoint();
        int higherPoint = CardType.ACE.getLowerAcePoint();

        for (int i = 1; i < aceCount; i++) {
            lowerPoint += CardType.ACE.getLowerAcePoint();
            higherPoint += CardType.ACE.getLowerAcePoint();
        }
        return new ArrayList<>(Arrays.asList(lowerPoint, higherPoint));
    }

    private int getMaxPoint(final List<Integer> sums) {
        return sums.stream()
            .filter(sum -> sum <= BLACK_JACK)
            .mapToInt(Integer::intValue)
            .max()
            .orElse(LOSE);
    }



}
