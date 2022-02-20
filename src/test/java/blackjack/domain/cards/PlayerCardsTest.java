package blackjack.domain.cards;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlayerCardsTest {

    @Test
    void 카드를_추가하면_sum이_업데이트된다() {
        PlayerCards playerCards = new PlayerCards(Arrays.asList(
            new Card(Shape.HEART, Denomination.THREE),
            new Card(Shape.HEART, Denomination.TWO)
        ));

        playerCards.addCard(new Card(Shape.HEART, Denomination.NINE));

        assertThat(playerCards.getSumOfCards()).isEqualTo(14);
    }

    @Test
    void 카드들의_숫자합이_10_초과일_때_ACE는_1점으로_sum에_업데이트된다() {
        PlayerCards playerCards = new PlayerCards(Arrays.asList(
            new Card(Shape.HEART, Denomination.KING),
            new Card(Shape.HEART, Denomination.KING)
        ));

        playerCards.addCard(new Card(Shape.HEART, Denomination.ACE));

        assertThat(playerCards.getSumOfCards()).isEqualTo(21);
    }

    @Test
    void 카드들의_숫자합이_10_이하일_때_ACE는_11점으로_sum에_업데이트된다() {
        PlayerCards playerCards = new PlayerCards(Arrays.asList(
            new Card(Shape.HEART, Denomination.THREE),
            new Card(Shape.HEART, Denomination.TWO)
        ));

        playerCards.addCard(new Card(Shape.HEART, Denomination.ACE));

        assertThat(playerCards.getSumOfCards()).isEqualTo(16);
    }

    @Test
    void 카드들의_숫자합이_21을_초과하면_카드를_더_받을_수_없다() {
        PlayerCards playerCards = new PlayerCards(Arrays.asList(
            new Card(Shape.HEART, Denomination.KING),
            new Card(Shape.HEART, Denomination.ACE)
        ));
        playerCards.addCard(new Card(Shape.CLUB,Denomination.KING));

        assertThat(playerCards.canReceiveMoreCard()).isFalse();
    }
}
