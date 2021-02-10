package blackjack.model;

import blackjack.model.Card;
import blackjack.model.CardType;
import blackjack.model.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {
    @Test
    @DisplayName("카드가 K위의 숫자인 14의 value로 입력될 때, 에러가 나는 테스트")
    void generateCardErrorTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new Card(CardType.DIAMOND, CardValue.of(14)));
    }

    @Test
    @DisplayName("Card가 9클로버 일 때, 이름이 제대로 나오는 지, 확인하는 테스트")
    void generate9CloverCardNameTest() {
        final Card card = new Card(CardType.CLOVER, CardValue.of(9));
        assertThat(card.toString()).isEqualTo("9클로버");
    }

    @Test
    @DisplayName("Card가 2하트 일 때, 이름이 제대로 나오는 지, 확인하는 테스트")
    void generate2HeartCardNameTest() {
        final Card card = new Card(CardType.HEART, CardValue.of(2));
        assertThat(card.toString()).isEqualTo("2하트");
    }

    @Test
    @DisplayName("Card가 K다이아 일 때, 점수가 제대로 나오는 지, 확인하는 테스트")
    void generateKDiamondCardScoreTest() {
        final Card card = new Card(CardType.DIAMOND, CardValue.of(12));
        final int score = card.getScore();
        assertThat(score).isEqualTo(10);
    }

    @Test
    @DisplayName("Card가 1스페이드 일 때, 점수가 제대로 나오는 지, 확인하는 테스트")
    void generate2HeartCardScoreTest() {
        final Card card = new Card(CardType.SPADE, CardValue.of(1));
        final int score = card.getScore();
        assertThat(score).isEqualTo(1);
    }
}