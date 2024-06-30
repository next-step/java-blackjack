package blackjack;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private static Cards pool = new Cards();

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 10;

    static {
        Arrays.stream(CardNumber.values()).forEach(number -> {
            pool.push(new Card(number, CardSuit.DIAMOND));
            pool.push(new Card(number, CardSuit.CLOVER));
            pool.push(new Card(number, CardSuit.HEART));
            pool.push(new Card(number, CardSuit.SPADE));
        });
//        Collections.shuffle(pool.getCards());
    }

    public Card getOneCard(Integer index) {
        return new Card(pool.getCards().get(index));
    }

    public Integer getSize() {
        return pool.getSize();
    }
}
