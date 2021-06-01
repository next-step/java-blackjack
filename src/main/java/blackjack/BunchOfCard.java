package blackjack;

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
                .map((card)->card.getName())
                .collect(Collectors.toList());
    }

    public int getCardValueSum() {
        return bunchOfCard.stream()
                .mapToInt((card)->card.getValue())
                .sum();
    }
}
