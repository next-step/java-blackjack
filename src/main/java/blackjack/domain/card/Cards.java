package blackjack.domain.card;

import blackjack.domain.state.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class Cards { //카드 리스트를 가진 일급 컬렉션.
    private static final int FINISH_BOUND = 21;
    private static final int BLACKJACK_CARD_NUMBER = 2;
    private static final int ACE_PLUS_SCORE = 10;
    private static final int ZERO = 0;
    private List<PlayingCard> cards;
    private Integer cardSum = ZERO;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public Integer getSum() {
        sumCards();
        return cardSum;
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public void add(PlayingCard card) {
        cards.add(card);
    }

    public boolean isBust() {
        sumCards();
        if (cardSum > FINISH_BOUND) {
            return true;
        }
        return false;
    }

    private void sumCards() {
        cardSum = ZERO;
        for (PlayingCard card : cards) {
            cardSum += card.getDenomination().getScore();
        }
        // ACE를 1이 아닌 11로 선택
        changeACEScore();
    }

    private void changeACEScore() {
        for (PlayingCard card : cards) {
            changeValidate(card);
        }
    }

    private void changeValidate(PlayingCard card) {
        if (card.getDenomination().isAce() && cardSum + ACE_PLUS_SCORE <= FINISH_BOUND) {
            cardSum += ACE_PLUS_SCORE;
        }
    }


    public boolean isBlackJack() {
        sumCards();
        if (cardSum == FINISH_BOUND && cards.size() == BLACKJACK_CARD_NUMBER) {
            return true;
        }
        return false;
    }
}
