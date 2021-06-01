package BlackJack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayGameTest {
    private List<Player> players;
    private PlayGame playGame;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        players = Arrays.asList(new Player("sy"), new Player("sg"));
        dealer = new Dealer();
        playGame = new PlayGame(players, dealer);
    }

    @DisplayName("발급된 수")
    @Test
    void playerDrawSize() {
        playGame.gameStart(2);
        Assertions.assertThat(players.get(0).getHoldingCards().size()).isEqualTo(2);
    }

    @DisplayName("딜러 발급된 수")
    @Test
    void dealerDrawSize() {
        playGame.gameStart(2);
        Assertions.assertThat(dealer.getHoldingCards().size()).isEqualTo(2);
    }
}