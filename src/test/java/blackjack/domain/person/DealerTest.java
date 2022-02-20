package blackjack.domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
    }

    @Test
    void 딜러는_초기화를_위해_두장의_카드를_반환한다() {
        //when then
        assertThat(dealer.getInitialPickedCards()).hasSize(2);
    }

    @Test
    void 딜러는_오픈용_카드를_반환한다() {
        //given
        Card actual = dealer.getDealerCards().getCards().get(0);

        //when then
        assertThat(dealer.getOpenedCard()).isEqualTo(actual);
    }
}
