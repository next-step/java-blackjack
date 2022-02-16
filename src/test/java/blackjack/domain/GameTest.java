package blackjack.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("Game_생성_테스트")
    @Test
    void createGameTest() {
        List<String> playerNames = Arrays.stream("pobi, jason".split(","))
            .map(String::trim)
            .collect(Collectors.toList());
        Game game = new Game(playerNames);
        assertAll(
            ()->assertThat(game.getPlayers()).isNotNull(),
            ()->assertThat(game.getDealer()).isNotNull()
        );
    }
}