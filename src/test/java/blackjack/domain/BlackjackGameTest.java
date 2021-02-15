package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackGameTest {
    @DisplayName("생성 및 플레이어 등록 테스트")
    @Test
    void initializeBlackjackGameTest() {
        // given & when
        List<Player> players = new ArrayList<>();
        players.add(new Player("a"));
        players.add(new Player("b"));
        BlackjackGame blackjackGame = new BlackjackGame(players);

        // then
        assertThat(blackjackGame.getPlayers()).isEqualTo(players);
        assertThat(blackjackGame.getDeck().getCards().size()).isEqualTo(52);
    }

    @DisplayName("giveCard 실행시 덱 감소 테스트")
    @Test
    void giveCardTest() {
        // given & when
        List<Player> players = new ArrayList<>();
        BlackjackGame blackjackGame = new BlackjackGame(players);
        blackjackGame.giveCard(blackjackGame.getDealer());

        // then
        assertThat(blackjackGame.getDeck().getCards().size()).isEqualTo(51);
    }
}
