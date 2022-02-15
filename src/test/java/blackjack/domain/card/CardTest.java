package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    @DisplayName("카드 이름을 반환한다.")
    @Test
    void When카드이름_얻기_Then이름_반환() {
        assertThat(new Card(Pattern.SPADE, Denomination.SEVEN).getName()).isEqualTo("7스페이드");
    }
}
