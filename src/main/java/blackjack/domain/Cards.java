package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    protected List<Card> cardList;

    // 52장 카드 만드는 생성자
    public Cards() {
        cardList = new ArrayList<>();
    }

    public void addCard(Card card) {
        cardList.add(card);
    }
}
