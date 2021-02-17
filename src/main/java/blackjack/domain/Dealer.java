package blackjack.domain;

import java.util.Objects;

public class Dealer extends Player {

    private static final String NAME_CARD = "딜러 카드: ";
    private static final int THRESHOLD_MORE_CARD = 16;
    private int winCount = 0;
    private int loseCount = 0;

    public Dealer(Deck deck) {
        super(deck);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(NAME_CARD).append(
            getCards()
                .getCards()
                .get(0)
                .toString()
        ).toString();
    }

    public void addWinCount() {
        winCount++;
    }

    public void addLoseCount() {
        loseCount++;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public Boolean addCardUnderScore() {
        if (getScore().getValue() <= THRESHOLD_MORE_CARD) {
            addCard(deck.popCard());
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dealer dealer = (Dealer) o;
        return winCount == dealer.winCount && loseCount == dealer.loseCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winCount, loseCount);
    }
}