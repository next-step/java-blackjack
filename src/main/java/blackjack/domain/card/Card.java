package blackjack.domain.card;

public class Card {
    private final Pattern pattern;
    private final Denomination denomination;

    public Card(final Pattern pattern, final Denomination denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
    }

    public String getName() {
        return denomination.getName() + pattern.getName();
    }
}
