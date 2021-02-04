package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {

    @DisplayName("Check if the players created correctly")
    @Test
    void generatePlayers() {
        assertEquals(
            Arrays.asList(
                new Player("pobi"),
                new Player("jason")
            ),
            PlayerFactory.generatePlayers("pobi,jason")
         );
    }
}