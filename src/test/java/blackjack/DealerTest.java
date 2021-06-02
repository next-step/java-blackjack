package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {
    @DisplayName("딜러는 카드의 이름들을 반환 할 수있다.")
    @Test
    void getNamesTest() {
        Dealer dealer = new Dealer();

        dealer.addCard(new Card(CardTypes.CLOVER_2));
        dealer.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(dealer.getCardNames()).contains("2클로버", "J다이아몬드");
    }

    @DisplayName("딜러는 카드들의 값의 합을 반환 할 수있다.")
    @Test
    void getCardValueSumTest() {
        Dealer dealer = new Dealer();

        dealer.addCard(new Card(CardTypes.CLOVER_2));
        dealer.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(dealer.getCardValueSum()).isEqualTo(12);
    }
}
