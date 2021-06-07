package blackjack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BlackJackGameTest {
    BlackJackGame blackJackGame = new BlackJackGame();
    List<Player> players;

    @BeforeEach
    void set() {
        players = blackJackGame.getPlayer("1,2");
    }

    @Test
    void getPlayer() {
        assertThat(players).usingElementComparatorOnFields("name").containsExactly(new Dealer(), new Gamer("1"), new Gamer("2"));
    }


    @DisplayName("뽑기 시작")
    @Test
    void 뽑기_시작() {
        blackJackGame.startDraw();
        assertThat(players.get(0).getCards().size()).isEqualTo(2);
    }

}
