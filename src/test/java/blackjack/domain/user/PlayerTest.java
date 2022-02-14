package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"jason", "pobi"})
    void 이름을_가진_플레이어를_생성한다(String name) {
        Player player = new Player(name);
        assertThat(player.name()).isEqualTo(name);
    }

    @Test
    void 이름은_공백이_들어올_수_없다() {
        assertThatThrownBy(() -> new Player(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
}