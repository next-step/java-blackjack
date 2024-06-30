package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void 카드는_그림을_갖는다2() {
        final CardNumber cardNumber = CardNumber.ACE;
        final Card card = new Card(cardNumber, CardSuit.DIAMOND);
        CardSuit actual = card.getSuit();
        Assertions.assertThat(actual).isEqualTo(CardSuit.DIAMOND);
    }

    @Test
    void 카드는_카드넘버를_갖는다2() {
        final CardNumber cardNumber = CardNumber.ACE;
        final Card card = new Card(cardNumber, CardSuit.DIAMOND);
        CardNumber actual = card.getNumber();
        Assertions.assertThat(actual.getNumber()).isEqualTo(1);
    }


}
