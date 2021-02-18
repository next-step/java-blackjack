package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayersFactoryTest {

    @DisplayName("Check if the players created correctly")
    @Test
    void generatePlayers() {
        assertEquals(
                new Players(
                        Arrays.asList(
                                new Player("pobi"),
                                new Player("jason")
                        )
                ),
                PlayersFactory.generatePlayers("pobi,jason")
        );
    }
}