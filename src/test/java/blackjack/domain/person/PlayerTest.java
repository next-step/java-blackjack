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
        assertThat(player.getPlayerCards().getCards()).hasSize(2);
    }

    @Test
    void ACE는_1과_11점_두가지_모두_가능하다() {
        //given
        Player player = new Player("kim", Arrays.asList(
            new Card(Shape.SPADE, Denomination.KING),
            new Card(Shape.SPADE, Denomination.ACE)
        ));

        //when
        int actual = player.getPlayerCards().getSumOfCards();

        //then
        assertThat(actual).isEqualTo(21);
    }
}
