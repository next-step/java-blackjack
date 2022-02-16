package blackjack.domain;

import blackjack.domain.Card.CardValue;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantCards {

    private final List<Card> cards;

    public ParticipantCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCards(List<Card> drawCards) {
        cards.addAll(drawCards);
    }

    public int sumCardScore() {
        int score = 0;

        score += cards.stream()
            .filter(card -> !CardValue.ACE.isEqualCardValue(card))
            .reduce(0, (x, y) -> x + y.getScore(x), Integer::sum);

        List<Card> aceCards = cards.stream()
            .filter(CardValue.ACE::isEqualCardValue)
            .collect(Collectors.toList());

        for (Card card : aceCards) {
            score += card.getScore(score);
        }

        return score;
    }
}
