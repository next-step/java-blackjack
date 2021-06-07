package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BunchOfCard {
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
        return bunchOfCard.stream().filter(card -> card.getValue() == 1).count() > 1;
    }

    private int getCardValueSumContainsA(int cardValueSum) {
        if (cardValueSum <= 21) {
            return cardValueSum + 10;
        }

        return cardValueSum;
    }
}
