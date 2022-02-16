package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {
    public static final int ONE = 1;

    @DisplayName("딜러는 카드를 한 장씩 꺼낼 수 있다")
    @Test
    void testAllocateCard() {
        Dealer dealer = new Dealer();
        Player player = new Player("플레이어");
        dealer.allocateCard(player);
        assertThat(player.getCards().size()).isEqualTo(ONE);
    }

    @DisplayName("처음 받은 2장의 카드 합계가 16이하라면 카드 한 장을 추가로 받는다")
    @Test
    void testAddOneMoreCard() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.FIVE));
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.SIX));
        dealer.addOneMoreCard();
        assertThat(dealer.getCards().size()).isEqualTo(3);
    }

    @DisplayName("처음 받은 2장의 카드 합계가 16이상이면 카드 한 장을 추가로 받지 않는다")
    @Test
    void testAddOneMoreCardFail() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.NINE));
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.EIGHT));
        dealer.addOneMoreCard();
        assertThat(dealer.getCards().size()).isEqualTo(2);
    }
}