package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @DisplayName("Card 의 정적팩토리 메서드를 이용한 생성 테스트")
    @Test
    void ofTest() {
        Card card = Card.of(Type.HEART, Symbol.JACK);
        assertThat(card.getType()).isEqualTo(Type.HEART);
        assertThat(card.getSymbol()).isEqualTo(Symbol.JACK);
    }

}