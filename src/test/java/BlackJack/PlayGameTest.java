package BlackJack;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;
import BlackJack.actor.Players;
import BlackJack.game.PlayGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayGameTest {
    private Players players;
    private PlayGame playGame;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        players.add( new Player("ss"));
        players.add( new Player("yy"));
        dealer = new Dealer();
        playGame = new PlayGame(players, dealer);
    }

    @DisplayName("발급된 수")
    @Test
    void playerDrawSize() {
        playGame.gameStart(2);
        Assertions.assertThat(players.getPlayers().get(0).getHoldingCards().size()).isEqualTo(2);
    }

    @DisplayName("딜러 발급된 수")
    @Test
    void dealerDrawSize() {
        playGame.gameStart(2);
        Assertions.assertThat(dealer.getHoldingCards().size()).isEqualTo(2);
    }
}
