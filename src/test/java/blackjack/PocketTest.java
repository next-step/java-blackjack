package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PocketTest {
    @Test
    @DisplayName("카드들의 이름을 출력하는 테스트")
    void getCardsTest() {
        final Pocket pocket = new Pocket();
        pocket.add(new Card(CardType.CLOVER, CardValue.ONE));
        final String cardsName = pocket.getCardsName();
        assertThat(cardsName).isEqualTo("1클로버");
    }

    @Test
    @DisplayName("빈 포켓의 카드의 이름을 출력하면 오류가 나는 테스트")
    void getCardsNameErrorTest() {
        final Pocket pocket = new Pocket();
        assertThrows(IllegalStateException.class, pocket::getCardsName);
    }
}