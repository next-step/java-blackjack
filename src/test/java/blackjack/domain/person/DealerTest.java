package blackjack.domain.person;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import org.junit.jupiter.api.Test;

class DealerTest {
    @Test
    void 딜러를_생성하면_카드목록의_사이즈가_2여야_한다() {
        //given
        Dealer dealer = new Dealer(
            new Card(Shape.HEART, Denomination.EIGHT),
            new Card(Shape.HEART, Denomination.FIVE)
        );

        //when
        int cardSize = dealer.getCards().size();

        //then
        assertThat(cardSize).isEqualTo(2);
    }

    @Test
    void 플레이어는_받은_카드_1장을_목록에_추가해야_한다() {
        //given
        Dealer dealer = new Dealer(
            new Card(Shape.HEART, Denomination.EIGHT),
            new Card(Shape.HEART, Denomination.FIVE)
        );
         dealer.addCard(new Card(Shape.HEART, Denomination.NINE));

        //when
        int cardSize =  dealer.getCards().size();

        //then
        assertThat(cardSize).isEqualTo(3);
    }
}
