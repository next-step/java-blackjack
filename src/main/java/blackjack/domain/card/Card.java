package blackjack.domain.card;

import java.util.Objects;

public class Card {

    private final Pattern pattern;
    private final Rank rank;

    public Card(final Pattern pattern, final Rank rank) {
        this.pattern = pattern;
        this.rank = rank;
    }

    public boolean isAce() {
        return rank == Rank.ACE;
    }

    public String getName() {
        return rank.getName() + pattern.getName();
    }

    public int getRank() {
        return rank.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return pattern == card.pattern && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, rank);
    }
}
