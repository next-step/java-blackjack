package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @DisplayName("딜러가 카드를 더 받을 것인지 판단 테스트 : 합 16 => true")
    @Test
    void isActiveTrueTest() {
        // given
        Dealer dealer = new Dealer();
        Card card1 = new Card(Denomination.KING, Suit.CLOVER);
        Card card2 = new Card(Denomination.SIX, Suit.HEART);

        // when
        dealer.hit(card1);
        dealer.hit(card2);

        // then
        assertThat(dealer.isActive()).isEqualTo(true);
    }

    @DisplayName("딜러가 카드를 더 받을 것인지 판단 테스트 : 합 17 => false")
    @Test
    void isActiveFalseTest() {
        // given
        Dealer dealer = new Dealer();
        Card card1 = new Card(Denomination.TEN, Suit.CLOVER);
        Card card2 = new Card(Denomination.SEVEN, Suit.HEART);

        // when
        dealer.hit(card1);
        dealer.hit(card2);

        // then
        assertThat(dealer.isActive()).isEqualTo(false);
    }
}
