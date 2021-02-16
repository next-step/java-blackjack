package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards { //카드 리스트를 가진 일급 컬렉션.

    private static final int BLACKJACK = 21;
    private static final int DEALER_CARD_PICK_CONDITION = 16;
    private List<PlayingCard> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public List<PlayingCard> getCardsAsList() {
        return cards;
    }

    public void add(PlayingCard card) {
        cards.add(card);
    }

    public boolean isBust() {
        final int cardSum = sumScore();
        return cardSum > BLACKJACK;
    }

    public boolean isBlackJack() {
        final int cardSum = sumScore();
        return cardSum == BLACKJACK;
    }

    public int sumScore() {
        int sumScore = cards.stream()
            .mapToInt(card -> card.getDenomination().getScore())
            .sum();
        if(hasAce() && sumScore < 12) {
            sumScore += 10;
        }
        return sumScore;
    }

    private boolean hasAce() {
        return cards.stream().anyMatch(card -> card.getDenomination().isAce());
    }

    public boolean checkDealerCardCondition() {
        return sumScore() <= DEALER_CARD_PICK_CONDITION;
    }
}
