package blackjack.domain.card;

import blackjack.domain.state.PlayingCard;
import java.util.ArrayList;
import java.util.List;

public class Cards { //카드 리스트를 가진 일급 컬렉션.
    private static final int FINISH_BOUND = 21;
    private List<PlayingCard> cards;
    private int cardSum;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(PlayingCard card) {
        cards.add(card);
    }

    public boolean isBust() {
        cardSum = 0;
        for(PlayingCard card : cards) {
            cardSum += card.getDenomination().getScore();
        }
        if(cardSum > FINISH_BOUND) {
            return true;
        }
        return false;
    }

    public boolean isBlackJack() {
        cardSum = 0;
        for(PlayingCard card : cards) {
            cardSum += card.getDenomination().getScore();
        }
        if(cardSum == FINISH_BOUND) {
            return true;
        }
        return false;
    }

    public Card pop() {
        return null;
    }

    public void mergeCards(Cards cards){
        this.cards.addAll(cards.cards);
    }
}
