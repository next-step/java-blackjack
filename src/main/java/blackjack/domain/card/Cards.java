package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private static List<Card> cardList = new ArrayList<>();

    static {
        for(Denomination denomination : Denomination.values()) {
            for(Suit suit : Suit.values()) {
                cardList.add(new Card(denomination, suit));
            }
        }
    }

    public static List<Card> getCardList() {
        return cardList;
    }

}
