package blackjack.domain.gamer;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    void 초기에_카드는_섞여서_2개가_주어진다() {
        Dealer dealer = new Dealer();
        assertThat(dealer.getCards().size()).isEqualTo(2);
    }

    @Test
    void 두_카드의_합이_16_이하일_경우_카드를_추가로_한장_받는다() {
        Dealer dealer = new Dealer(Arrays.asList(new Card(Denomination.TWO, Suit.DIAMONDS),
            new Card(Denomination.TEN, Suit.DIAMONDS)));
        assertThat(dealer.getCardOrNot(dealer)).isTrue();
    }

    @Test
    void 두_카드의_합이_16_초과일_경우_카드를_추가로_받지_않는다() {
        Dealer dealer = new Dealer(Arrays.asList(new Card(Denomination.NINE, Suit.DIAMONDS),
            new Card(Denomination.TEN, Suit.DIAMONDS)));
        assertThat(dealer.getCardOrNot(dealer)).isFalse();
    }
}
