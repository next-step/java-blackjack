package blackjack.domain;

import blackjack.dto.CardBunchInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CardBunch {

    private static final Integer BLACKJACK_LIMIT = 21;
    private static final Integer ACE_LIMIT = 12;

    private final List<Card> cardBunches;

    public CardBunch() {
        this.cardBunches = new ArrayList<>();
    }

    public CardBunch(List<Card> cardBunch) {
        this.cardBunches = cardBunch;
    }

    public CardBunch(List<Integer> denom, Suit suit) {
        cardBunches = denom.stream().map(
                n -> new Card(
                        Denomination.of(n),
                        suit
                )
        ).collect(
                Collectors.toList()
        );
    }

    public void drawCard(Deck deck) {
        cardBunches.add(
                deck.drawCard()
        );
    }

    public boolean isBust() {
        return calcScore() > BLACKJACK_LIMIT;
    }

    public boolean isBlackJack() {
        return calcScore().equals(BLACKJACK_LIMIT);
    }

    public Integer calcScore() {
        int score = cardBunches.stream().mapToInt(
                Card::getScore
        ).sum();

        if (isHaveAce() && score < ACE_LIMIT) {
            return score + 10;
        }
        return score;
    }

    private boolean isHaveAce() {
        return cardBunches.stream().anyMatch(
                Card::isAce
        );
    }

    public CardBunchInfo getCardBunchInfo() {
        return new CardBunchInfo(
                cardBunches.stream().map(
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
        return Objects.equals(cardBunches, cardBunch1.cardBunches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardBunches);
    }
}
