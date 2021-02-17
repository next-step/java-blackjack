package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cards {

    private static final int BLACKJACK = 21;
    protected List<Card> cards;
    private int cardSum;

    public Cards() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    private int getCardSum() {
        return cards.stream()
            .mapToInt(
                card -> card.getDenomination().getScore()
            ).sum();
    }

    private int getAceCount() {
        return Long.valueOf(cards.stream()
            .filter(
                card -> card.getDenomination().isAce()
            ).count()).intValue();
    }

    private void addScore() {
        if (cardSum + Denomination.ACE.getScore() <= BLACKJACK) {
            cardSum += 10;
        }
    }

    public Score getScore() {
        cardSum = getCardSum();
        IntStream.range(0, getAceCount())
            .forEach(i -> addScore());
        return new Score(cardSum);
    }

    @Override
    public String toString() {
        return cards.stream()
            .map(Card::toString)
            .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cards cards = (Cards) o;
        return cardSum == cards.cardSum && Objects.equals(this.cards, cards.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, cardSum);
    }
}
