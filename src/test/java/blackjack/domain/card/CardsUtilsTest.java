package blackjack.domain.card;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class CardsUtilsTest {

    @ParameterizedTest
    @EnumSource(value = Denomination.class, names = {"THREE", "SIX"})
    void 카드들의_숫자합을_구한_것이_특정값보다_작거나_같으면_참이_나와야_한다(Denomination value) {

        //given
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Shape.HEART, Denomination.KING));
        cards.add(new Card(Shape.HEART, Denomination.FIVE));
        cards.add(new Card(Shape.HEART, value));

        //when
        boolean result = CardsUtils.isSumOfCardValueSmallerThanOrEquals(cards, 21);

        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @EnumSource(value = Denomination.class, names = {"EIGHT", "NINE"})
    void 카드들의_숫자합을_구한_것이_특정값보다_크면_짓짓이_나와야_한다(Denomination value) {

        //given
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Shape.HEART, Denomination.KING));
        cards.add(new Card(Shape.HEART, Denomination.FIVE));
        cards.add(new Card(Shape.HEART, value));

        //when
        boolean result = CardsUtils.isSumOfCardValueSmallerThanOrEquals(cards, 21);

        //then
        assertFalse(result);
    }
}
