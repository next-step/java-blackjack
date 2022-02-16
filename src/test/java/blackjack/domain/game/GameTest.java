package blackjack.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("카드를 한장 뽑는다.")
    @Test
    void GivenNothing_When_Then() {
        assertThat(new Game().draw()).isNotNull();

    }

    @DisplayName("참가자들의 초기 패를 뽑는다.")
    @Test
    void Given_When_Then() {
        assertThat(new Game().dealCards().size()).isEqualTo(2);
    }
}