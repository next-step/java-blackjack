package blackjack;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;

    @BeforeEach
    public void init() {
        player = new Player("a", new Cards(Arrays.asList(new Card(Suit.CLUB, CardNumber.EIGHT),
            new Card(Suit.DIAMOND, CardNumber.FIVE))));
    }

    @Test
    public void 카드점수_확인_테스트() {
        Assertions.assertThat(player.getTotalScore()).isEqualTo(13);
    }


}
