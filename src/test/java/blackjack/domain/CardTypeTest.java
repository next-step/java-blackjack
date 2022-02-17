package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTypeTest {

    @Test
    void 카드_타입_크기_확인() {
        assertThat(CardType.values()).hasSize(4);
    }

    @Test
    void 카드_타입_확인() {
        CardType cardType = CardType.DIAMOND;
        assertThat(cardType.getType()).isEqualTo("다이아몬드");
    }
}
