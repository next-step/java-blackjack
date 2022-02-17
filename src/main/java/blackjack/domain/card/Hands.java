package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hands {

    private static final int DECISION_VALUE = 10;
    private static final int ACE_VALUE_1 = 1;
    private static final int ACE_VALUE_11 = 11;

    private final List<Card> cards;
    private Score score;

    public Hands(final List<Card> cards) {
        this.cards = new ArrayList<>();
        this.score = new Score();

        initAllField(cards);
    }

    private void initAllField(final List<Card> cards) {
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
            return ACE_VALUE_1;
        }
        return ACE_VALUE_11;
    }

    public boolean isUnderScore(final int value) {
        return score.isUnder(value);
    }

    public int getScore() {
        return score.getValue();
    }

    public List<String> getCardNames() {
        return cards.stream().map(Card::getName).collect(Collectors.toList());
    }
}
