package blackjack.domain.card;

import blackjack.domain.score.ScoreCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardBundle {

    private static final int BLACK_JACK_SCORE = 21;

    private final List<Card> cards;

    private CardBundle() {
        this.cards = new ArrayList<>();
    }

    public static CardBundle emptyBundle() {
        return new CardBundle();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        return ScoreCalculator.findByCards(cards)
            .calculateScore(cards);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public boolean isBurst() {
        return calculateScore() > BLACK_JACK_SCORE;
    }

    public boolean isBlackJack() {
        return calculateScore() == BLACK_JACK_SCORE;
    }
}
