package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Denomination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DenominationTest {

    @DisplayName(value = "KING의 계산값은 10으로 정의한다")
    @Test
    void 킹의_계산값은_10이다() {
        assertThat(Denomination.KING.getValue()).isEqualTo(10);
    }

    @DisplayName(value = "퀸의 계산값은 10으로 정의한다")
    @Test
    void 퀸의_계산값은_10이다() {
        assertThat(Denomination.QUEEN.getValue()).isEqualTo(10);
    }

    @DisplayName(value = "JACK의 계산값은 10으로 정의한다")
    @Test
    void 잭의_계산값은_10이다() {
        assertThat(Denomination.JACK.getValue()).isEqualTo(10);
    }

}
