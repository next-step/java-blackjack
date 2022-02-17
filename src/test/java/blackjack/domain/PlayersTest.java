package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void 플레이어_만들기_테스트() {
        Players players = Players.createPlayers(Arrays.asList("a", "b", "c", "d"));

        assertThat(players.getPlayers().size()).isEqualTo(4);
    }
}
