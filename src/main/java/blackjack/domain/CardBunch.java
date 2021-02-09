package blackjack.domain;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardBunch {
    private static final Integer BUST_LIMIT = 21;

    private final List<Card> cardBunch;

    public CardBunch() {
        this.cardBunch = new ArrayList<>();
    }

    public CardBunch(List<Card> cardBunch) {
        this.cardBunch = cardBunch;
    }

    public CardBunch(List<Integer> score, Suit suit) {
        cardBunch = score.stream().map(
            n -> new Card(
                Denomination.of(n),
                suit
            )
        ).collect(
            Collectors.toList()
        );
    }

    public void drawCard(Deck deck) {
        cardBunch.add(
            deck.drawCard()
        );
    }

    public boolean isUnderLimit(Integer limit) {
        return calcScore() < limit;
    }

    public boolean isBust() {
        return calcScore() > BUST_LIMIT;
    }

    private Integer calcScore() {
        int score = cardBunch.stream().mapToInt(
            Card::getScore
        ).sum();
        boolean haveAce = cardBunch.stream().anyMatch(
            Card::isAce
        );

        if (haveAce && score < 12) {
            return score + 10;
        }
        return score;
    }

    public CardBunchInfo getCardBunchInfo() {
        return new CardBunchInfo(
            cardBunch.stream().map(
                Card::getCardInfo
            ).collect(
                Collectors.toList()
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardBunch cardBunch1 = (CardBunch) o;
        return Objects.equals(cardBunch, cardBunch1.cardBunch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardBunch);
    }
}
