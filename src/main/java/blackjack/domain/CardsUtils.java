package blackjack.domain;

import java.util.List;

public class CardsUtils {

    public static boolean isSumOfCardValueSmallerThanOrEquals(List<Card> cards, Integer target) {
        Integer sumOfValue = getSumOfValue(cards);
        return isSmallerThanOrEquals(sumOfValue, target);
    }

    private static Integer getSumOfValue(List<Card> cards) {
        return cards.stream()
            .mapToInt(card -> card.getDenomination().getValue())
            .sum();
    }

    private static boolean isSmallerThanOrEquals(Integer number, Integer target) {
        return number <= target;
    }
}
