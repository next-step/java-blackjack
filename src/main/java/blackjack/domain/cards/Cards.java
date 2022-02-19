package blackjack.domain.cards;

import blackjack.domain.card.Card;

public interface Cards {

    /**
     * 카드를 카드 목록에 추가한다.
     *
     * @return void
     * @Param Card
     */
    void addCard(Card card);

    /**
     * 카드 denomination 의 합을 반환
     *
     * @return int
     */
    int getSumOfCards();

}
