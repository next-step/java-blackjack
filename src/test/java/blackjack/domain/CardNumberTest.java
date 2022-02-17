package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CardNumberTest {

    @Test
    void 카드_전체_크기_확인() {
        assertThat(CardNumber.values()).hasSize(13);
    }

    @Test
    void 카드_확인() {
        CardNumber cardNumber = CardNumber.ACE;
        assertTrue(cardNumber.isAce());
    }
}
