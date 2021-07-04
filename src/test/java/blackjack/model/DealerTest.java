package blackjack.model;

import blackjack.model.state.Hit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @DisplayName("딜러는 카드의 이름들을 반환 할 수있다.")
    @Test
    void getCardNamesTest() {
        BunchOfCard bunchOfCard = new BunchOfCard();

        bunchOfCard.addCard(new Card(CardTypes.CLOVER_2));
        bunchOfCard.addCard(new Card(CardTypes.DIAMOND_J));

        Dealer dealer = new Dealer(new Hit(bunchOfCard));

        assertThat(dealer.getCardNames()).contains("2클로버", "J다이아몬드");
    }

    @DisplayName("딜러는 카드들의 값의 합을 반환 할 수있다.")
    @Test
    void getDealerCardValueSumTest() {
        BunchOfCard bunchOfCard = new BunchOfCard();

        bunchOfCard.addCard(new Card(CardTypes.CLOVER_2));
        bunchOfCard.addCard(new Card(CardTypes.DIAMOND_J));

        Dealer dealer = new Dealer(new Hit(bunchOfCard));

        assertThat(dealer.getCardValueSum()).isEqualTo(12);
    }
}
