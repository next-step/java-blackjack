package blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {
    @Test
    void 카드목록은_카드를_갖는다() {
        final Cards cards = new Cards(List.of(
                new Card(CardNumber.ACE, CardSuit.CLOVER),
                new Card(CardNumber.JACK, CardSuit.HEART)
        ));

        Integer size = cards.getSize();

        assertThat(size).isEqualTo(2);
    }

    @Test
    void 카드를_한장_추가한다() {
        Cards cards = new Cards();
        CardNumber cardNumber = CardNumber.ACE;
        Card card = new Card(cardNumber, CardSuit.DIAMOND);

        cards.push(card);

        Integer size = cards.getSize();

        assertThat(size).isEqualTo(1);
    }
}
