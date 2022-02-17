package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
     void 모든_카드는_52장이다() {
        List<Card> cardList = new ArrayList<>();
        for(Denomination denomination : Denomination.values()) {
            for(Suit suit : Suit.values()) {
                cardList.add(new Card(denomination, suit));
            }
        }
        assertThat(cardList.size()).isEqualTo(52);
    }
}
