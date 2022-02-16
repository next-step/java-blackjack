package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int total = cards.stream().mapToInt(card -> card.getDenomination().getScore()).sum();
        int aceCount = (int) cards.stream().filter(card -> card.getDenomination().isAce()).count();
        for (int i = 0; i < aceCount; i++) {
            total = checkAceOneOrEleven(total);
        }

        return total;
    }

    private int checkAceOneOrEleven(int total) {
        if (total + 10 <= 21) {
            return total + 10;
        }
        return total;
    }

    public List<Card> getCards() {
        return cards;
    }
}
