package blackjack.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class GameSetupTest {

    @Test
    void 딜러와_플레이어를_만들면_카드덱과_이름과_카드_두_장을_가진다() {
        GameSetup gameSetup = new GameSetup(Arrays.asList("a", "b", "c"));

        assertAll(
            () -> assertThat(gameSetup.getDealer().getCards()).hasSize(2),
            () -> assertThat(gameSetup.getPlayers()).hasSize(3),
            () -> assertThat(gameSetup.getPlayers().stream().allMatch(player -> player.getCards().size() == 2)).isTrue()
        );
    }
}
