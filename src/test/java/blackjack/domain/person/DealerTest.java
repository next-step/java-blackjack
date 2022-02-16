package blackjack.domain.person;

import static org.assertj.core.api.Assertions.assertThat;
import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import java.util.List;
import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    void 카드를_init하면_2장의_카드를_가져야_한다() {
        Dealer dealer = new Dealer();
        dealer.initCards(
            new Card(Shape.CLUB, Denomination.FOUR),
            new Card(Shape.SPADE, Denomination.KING));

        assertThat(dealer.getCards()).hasSize(2);
    }

    @Test
    void 딜러는_받은_카드_1장을_목록에_추가해야_한다() {
        //given
        Dealer dealer = new Dealer();
        dealer.initCards(
            new Card(Shape.HEART, Denomination.NINE),
            new Card(Shape.HEART, Denomination.NINE)
        );
        dealer.addCard(new Card(Shape.HEART, Denomination.NINE));

        //when then
        assertThat(dealer.getCards()).hasSize(3);
    }

    @Test
    void 딜러는_전달_받은_수만큼_카드덱에서_카드를_뽑아_반환한다() {
        //given
        Dealer dealer = new Dealer();

        //when
        List<Card> pickedCard = dealer.getPickedCard(4);

        //then
        assertThat(pickedCard).hasSize(4);
    }
}
