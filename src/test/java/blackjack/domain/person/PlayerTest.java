package blackjack.domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 플레이어를_생성하면_카드를_두장_가져야_한다() {
        //given, when
        Player player = new Player("kim", Arrays.asList(
            new Card(Shape.SPADE, Denomination.KING),
            new Card(Shape.SPADE, Denomination.KING)
        ));

        //then
        assertThat(player.getCards()).hasSize(2);
    }

    @Test
    void 플레이어는_받은_카드_1장을_목록에_추가해야_한다() {
        //given
        Player player = new Player("kim", Arrays.asList(
            new Card(Shape.SPADE, Denomination.KING),
            new Card(Shape.SPADE, Denomination.KING)
        ));
        player.addCard(new Card(Shape.HEART, Denomination.KING));

        //when then
        assertThat(player.getCards()).hasSize(3);
    }
}
