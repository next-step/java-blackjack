package BlackJack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CasinoPersonTest {
    private Player player;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        player = new Player("sg");
        dealer = new Dealer();
    }

    @DisplayName("플레이어는 들고있는 카드의 합산 점수가 21점 이하면 카드를 draw할 수 있다.")
    @Test
    void isDrawPlayerTest() {
        Assertions.assertThat(player.isDrawCard(22)).isEqualTo(false);
    }

    @DisplayName("딜러는 들고있는 카드의 합산 점수가 16점 이하면 카드를 draw할 수 있다.")
    @Test
    void isDrawDealerTest() {
        Assertions.assertThat(player.isDrawCard(15)).isEqualTo(true);
    }
}