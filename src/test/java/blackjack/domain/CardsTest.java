package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
     void 모든_카드를_출력한다() {
        List<Card> cardList = new ArrayList<>();
        for(Denomination denomination : Denomination.values()) {
            for(Suit suit : Suit.values()) {
                cardList.add(new Card(denomination, suit));
            }
        }
        cardList.forEach(card -> System.out.println(new StringBuilder().append(card.getDenomination().getName()).append(card.getSuit().getValue())));
    }
}
