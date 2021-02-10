package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CardBundleTest {

    @DisplayName("cardBundle 의 객체생성 테스트")
    @Test
    void ofTest() {
        Type diamond = Type.DIAMOND;

        CardBundle cardBundle = CardBundle.of(Arrays.asList(
                Card.of(diamond, Symbol.ACE),
                Card.of(diamond, Symbol.JACK)
        ));

        assertThat(cardBundle.getCards().get(0)).isEqualTo(Card.of(diamond, Symbol.ACE));
    }
}
