package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardGeneratorTest {
    @DisplayName("카드 생성기는 카드덱의 남은 카드 수량을 알 수있다.")
    @Test
    void test1() {
        CardGenerator cardGenerator = new CardGenerator();
        cardGenerator.getOneCard();

        assertThat(cardGenerator.getLeftCardCount()).isEqualTo(51);
    }

    @DisplayName("카드 생성기는 카드 1장을 반환 할 수 있다.")
    @Test
    void getOneCard() {
        CardGenerator cardGenerator = new CardGenerator();

        assertThat(cardGenerator.getOneCard().getClass()).isEqualTo(Card.class);
    }

    @DisplayName("카드 생성기는 카드 여러장을 반환 할 수 있다.")
    @Test
    void getTwoCards() {
        CardGenerator cardGenerator = new CardGenerator();

        assertThat(cardGenerator.getSeveralCard(2).size()).isEqualTo(2);
    }
}
