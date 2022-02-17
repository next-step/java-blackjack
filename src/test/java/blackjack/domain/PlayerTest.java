package blackjack.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import blackjack.domain.card.CardDeck;
import blackjack.domain.player.Player;
import blackjack.domain.state.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어_생성_테스트")
    @Test
    void createPlayer() {
        Player player = new Player("pobi", new State(CardDeck.pop(2), true));
        assertAll(
            () -> assertThat(player.getName()).isEqualTo("pobi"),
            () -> assertThat(player).isNotNull()
        );
    }
}