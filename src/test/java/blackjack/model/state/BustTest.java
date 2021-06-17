package blackjack.model.state;

import blackjack.model.BunchOfCard;
import blackjack.model.Card;
import blackjack.model.CardTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BustTest {
    private BunchOfCard bunchOfCard;

    @BeforeEach
    void setUpUser() {
        bunchOfCard = new BunchOfCard();

        bunchOfCard.addCard(new Card(CardTypes.CLOVER_A));
        bunchOfCard.addCard(new Card(CardTypes.DIAMOND_J));
        bunchOfCard.addCard(new Card(CardTypes.DIAMOND_K));
    }

    @DisplayName("Bust 상태를 생성 할 수 있다")
    @Test
    void generateHit() {
        State state = new Bust(bunchOfCard);

        assertThat(state.getClass()).isEqualTo(Bust.class);
    }


    @DisplayName("Bust 상태는 게임이 끝난 상태이다.")
    @Test
    void hitIsNotFinished() {
        State state = new Bust(bunchOfCard);

        assertThat(state.isFinished()).isEqualTo(true);
    }

    @DisplayName("Bust 보상은 베팅금액의 -1배이다.")
    @Test
    void hitCanNotGetProfit() {
        State state = new Bust(bunchOfCard);

        assertThat(state.profit(1)).isEqualTo(-1);
    }

    @DisplayName("Bust 상태에서 드로우를 할 수없다")
    @Test
    void keepHit() {
        State state = new BlackJack(bunchOfCard);

        assertThrows(IllegalArgumentException.class, () -> state.draw(new Card(CardTypes.CLOVER_3)));
    }
}
