package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PocketTest {
    @Test
    @DisplayName("카드들의 이름을 출력하는 테스트")
    void getCardsTest() {
        final Pocket pocket = new Pocket();
        pocket.add(new Card(CardType.CLOVER, CardValue.ONE));
        final String cardsName = pocket.getCardsName();
        assertThat(cardsName).isEqualTo("1클로버");
    }
}