package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CardTest {

    @DisplayName("cardValue 가 같은지 확인")
    @Test
    void cardValueEqual() {
        // given
        Card card1 = new Card(CardType.SPADE, CardValue.KING);
        Card card2 = new Card(CardType.CLOVER, CardValue.KING);

        // when
        boolean result = card1.getCardValue().isEqualCardValue(card2);

        // then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("일반카드 점수 확인")
    @Test
    void normalCardScore() {
        // given
        Card card = new Card(CardType.SPADE, CardValue.KING);

        // when
        int result = card.calculateScore(0);

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("에이스 점수가 1이 되는 경우")
    @ValueSource(ints = {15, 18, 20})
    @ParameterizedTest
    void aceCardScoreIsOne(final int currentScore) {
        // given
        Card card = new Card(CardType.SPADE, CardValue.ACE);

        // when
        int result = card.calculateScore(currentScore);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("에이스 점수가 1이 되는 경우")
    @ValueSource(ints = {0, 5, 14})
    @ParameterizedTest
    void aceCardScoreIsEleven(final int currentScore) {
        // given
        Card card = new Card(CardType.SPADE, CardValue.ACE);

        // when
        int result = card.calculateScore(currentScore);

        // then
        assertThat(result).isEqualTo(11);
    }
}
