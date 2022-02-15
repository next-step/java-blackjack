package blackjack.domain;

import java.util.List;

public class ParticipantCards {
    private final List<Card> cards;

    public ParticipantCards(List<Card> cards) {
        this.cards = cards;
    }

    public int sumCardScore() {
        return 1;
    }
}
