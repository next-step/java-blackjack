package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BunchOfCard {
    public static final int BURST_VALUE = 21;
    private static final int BLACK_JACK_VALUE = 21;
    private static final int BLACK_JACK_SIZE = 2;
    private static final int A_VALUE = 1;
    private static final int FOR_HIGH_A_VALUE = 10;

    private final List<Card> bunchOfCard = new ArrayList<>();

    public BunchOfCard() {
    }

    public BunchOfCard(BunchOfCard bunchOfCard) {
        this.bunchOfCard.addAll(bunchOfCard.getCards());
    }

    public void addCard(Card card) {
        bunchOfCard.add(card);
    }

    public List<String> getCardNames() {
        return bunchOfCard.stream()
                .map(Card::getName)
                .collect(Collectors.toList());
    }

    public int getCardValueSum() {
        int cardValueSum = bunchOfCard.stream()
                .mapToInt(Card::getValue)
                .sum();

        if (isContainsA()) {
            return getCardValueSumContainsA(cardValueSum);
        }

        return cardValueSum;
    }

    private boolean isContainsA() {
        return bunchOfCard.stream().anyMatch(card -> card.getValue() == A_VALUE);
    }

    private int getCardValueSumContainsA(int cardValueSum) {
        if (cardValueSum + FOR_HIGH_A_VALUE <= BURST_VALUE) {
            return cardValueSum + FOR_HIGH_A_VALUE;
        }

        return cardValueSum;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(bunchOfCard);
    }

    public boolean isBust() {
        return getCardValueSum() > BURST_VALUE;
    }

    public boolean isBlackJack() {
        return (getCardValueSum() == BLACK_JACK_VALUE && bunchOfCard.size() == BLACK_JACK_SIZE);
    }
}
