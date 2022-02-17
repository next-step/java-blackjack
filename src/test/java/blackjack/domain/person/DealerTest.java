package blackjack.domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
    }

    @Test
    void 딜러가_생성되면_카드를_두장_가지고_있어야_한다() {
        //when then
        assertThat(dealer.getCards()).hasSize(2);
    }

    @Test
    void 딜러는_받은_카드_1장을_목록에_추가해야_한다() {
        //given
        dealer.addCard(new Card(Shape.HEART, Denomination.NINE));

        //when then
        assertThat(dealer.getCards()).hasSize(3);
    }

    @Test
    void 딜러는_전달_받은_수만큼_카드덱에서_카드를_뽑아_반환한다() {
        //when
        List<Card> pickedCard = dealer.getPickedCard(4);

        //then
        assertThat(pickedCard).hasSize(4);
    }
}
