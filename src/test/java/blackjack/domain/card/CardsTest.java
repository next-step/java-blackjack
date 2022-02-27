package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {

    @DisplayName("Cards 객체 생성 테스트")
    @Test
    void createCardsTest() {
        Cards cards = new Cards(Arrays.asList(
            new Card(CardNumber.ACE, CardPattern.CLOVER),
            new Card(CardNumber.KING, CardPattern.HEART),
            new Card(CardNumber.NINE, CardPattern.DIAMOND))
        );
        assertAll(
            () -> assertThat(cards).isNotNull(),
            () -> assertThat(cards.getCards().size()).isEqualTo(3)
        );
    }

    @DisplayName("Cards 점수 계산 테스트")
    @Test
    void sumScoresOfCardsTest() {
        Cards cards = new Cards(Arrays.asList(
            new Card(CardNumber.TWO, CardPattern.CLOVER),
            new Card(CardNumber.KING, CardPattern.HEART),
            new Card(CardNumber.NINE, CardPattern.DIAMOND))
        );
        assertThat(cards.sumScore()).isEqualTo(21);
    }
}