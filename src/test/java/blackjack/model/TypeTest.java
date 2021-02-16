package blackjack.model;

import blackjack.model.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeTest {

    @DisplayName("Type enum class 의 toString 출력 테스트")
    @Test
    void toStringTest() {
        Type type = Type.DIAMOND;
        assertThat(type.toString()).isEqualTo("DIAMOND");

    }

}