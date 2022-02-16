package blackjack.domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 플레이어를_생성하면_이름을_가져야_한다() {
        //given, when
        Player player = new Player("kim");

        //then
        assertThat(player.getName()).isEqualTo("kim");
    }

    @Test
    void 카드를_init하면_두_장의_카드를_가져야_한다() {
        //given
        Player player = new Player("eo");

        //when
        player.initCards(
            new Card(Shape.HEART, Denomination.EIGHT),
            new Card(Shape.HEART, Denomination.KING)
        );

        //then
        assertThat(player.getCards()).hasSize(2);
    }

    @Test
    void 플레이어는_받은_카드_1장을_목록에_추가해야_한다() {
        //given
        Player player = new Player("eo");
        player.initCards(
            new Card(Shape.HEART, Denomination.NINE),
            new Card(Shape.HEART, Denomination.NINE)
        );
        player.addCard(new Card(Shape.HEART, Denomination.KING));

        //when then
        assertThat(player.getCards()).hasSize(3);
    }
}
