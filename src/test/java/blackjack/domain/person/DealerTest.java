package blackjack.domain.person;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    void 카드를_init하면_2장의_카드를_가져야_한다() {
        Dealer dealer = new Dealer();
        dealer.initCards(
            new Card(Shape.CLUB, Denomination.FOUR),
            new Card(Shape.SPADE, Denomination.KING));

        int cardSize = dealer.getCards().size();

        assertThat(cardSize).isEqualTo(2);
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

        //when
        int cardSize =  dealer.getCards().size();

        //then
        assertThat(cardSize).isEqualTo(3);
    }
}
