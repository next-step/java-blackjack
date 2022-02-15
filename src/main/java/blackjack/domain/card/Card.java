package blackjack.domain.card;

public class Card {
    private final Pattern pattern;
    private final Rank rank;

    public Card(final Pattern pattern, final Rank rank) {
        this.pattern = pattern;
        this.rank = rank;
    }

    public String getName() {
        return rank.getName() + pattern.getName();
    }

    public boolean isAce() {
        return this.rank == Rank.ACE;
    }
}
