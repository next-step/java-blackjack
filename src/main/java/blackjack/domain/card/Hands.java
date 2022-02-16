package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hands {

    private static final int DECISION_VALUE = 10;
    private static final int ONE_ACE_VALUE = 1;
    private static final int ELEVEN_ACE_VALUE = 11;

    private final List<Card> cards;
    private Score score;

    public Hands(final List<Card> cards) {
        this.cards = new ArrayList<>();
        this.score = new Score();

        init(cards);
    }

    private void init(final List<Card> cards) {
        cards.forEach(this::add);
    }

    public void add(final Card card) {
        this.cards.add(card);
        this.score = this.score.sum(getRank(card));
    }

    private int getRank(final Card card) {
        if (card.isAce()) {
            return getAceValue();
        }
        return card.getRank();
    }

    private int getAceValue() {
        if (this.score.getValue() > DECISION_VALUE) {
            return ONE_ACE_VALUE;
        }
        return ELEVEN_ACE_VALUE;
    }

    public boolean isUnderScore(int value) {
        return score.isUnder(value);
    }

    public int getScore() {
        return score.getValue();
    }

    public List<String> getCardNames() {
        return cards.stream().map(Card::getName).collect(Collectors.toList());
    }
}
