package blackjack.model;

import blackjack.controller.BlackJackController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BunchOfCard {
    private static final int A_VALUE = 1;
    private static final int HAVE_A_COUNT = 0;
    private static final int FOR_HIGH_A_VALUE = 10;

    private final List<Card> bunchOfCard;

    public BunchOfCard() {
        this.bunchOfCard = new ArrayList<>();
    }

    public void addCard(Card card) {
        bunchOfCard.add(card);
    }

    public List<String> getCardNames() {
        return bunchOfCard.stream()
                .map((card) -> card.getName())
                .collect(Collectors.toList());
    }

    public int getCardValueSum() {
        int cardValueSum = bunchOfCard.stream()
                .mapToInt((card) -> card.getValue())
                .sum();

        if (isContainsA()) {
            return getCardValueSumContainsA(cardValueSum);
        }
        return cardValueSum;
    }

    private boolean isContainsA() {
        return bunchOfCard.stream().filter(card -> card.getValue() == A_VALUE).count() > HAVE_A_COUNT;
    }

    private int getCardValueSumContainsA(int cardValueSum) {
        if (cardValueSum + FOR_HIGH_A_VALUE <= BlackJackController.BURST_COUNT) {
            return cardValueSum + FOR_HIGH_A_VALUE;
        }

        return cardValueSum;
    }
}
