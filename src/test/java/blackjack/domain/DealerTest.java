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
}