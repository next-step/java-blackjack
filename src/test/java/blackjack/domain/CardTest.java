package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    void toStringTest() {
        // given
        Card card1 = new Card(Suit.CLUBS, Denomination.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Denomination.JACK);

        // when
        String card1ToString = card1.toString();
        String card1Target = "A클로버";
        String card2ToString = card2.toString();
        String card2Target = "J다이아몬드";

        // then
        Assertions.assertThat(card1ToString).isEqualTo(card1Target);
        Assertions.assertThat(card2ToString).isEqualTo(card2Target);
    }
}
