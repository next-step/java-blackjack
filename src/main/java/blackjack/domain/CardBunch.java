package blackjack.domain;

import blackjack.dto.CardBunchInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class CardBunch {
    private static final Integer BLACK_JACK_SCORE = 21;

    protected final List<Card> cardBunch;

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

    // TODO: 생성자 없애는법 알아보기

    public abstract boolean canDrawCard();

    public void drawCard(Deck deck) {
        cardBunch.add(
            deck.drawCard()
        );
    }

    public boolean isBlackJack() { return calcScore().equals(BLACK_JACK_SCORE); }

    public boolean isBust() {
        return calcScore() > BLACK_JACK_SCORE;
    }

    protected Integer calcScore() {
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
