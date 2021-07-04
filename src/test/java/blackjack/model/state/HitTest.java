package blackjack.model.state;

import blackjack.model.BunchOfCard;
import blackjack.model.Card;
import blackjack.model.CardTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HitTest {
    private BunchOfCard bunchOfCard;

    @BeforeEach
    void setUpUser() {
        bunchOfCard = new BunchOfCard();

        bunchOfCard.addCard(new Card(CardTypes.CLOVER_2));
        bunchOfCard.addCard(new Card(CardTypes.DIAMOND_J));
    }

    @DisplayName("Hit 상태를 생성 할 수 있다")
    @Test
    void generateHit() {
        assertDoesNotThrow(() -> new Hit(bunchOfCard));
    }

    @DisplayName("Hit 상태는 게임이 끝나지 않은 상태이다(= 진행중).")
    @Test
    void hitIsNotFinished() {
        State state = new Hit(bunchOfCard);

        assertThat(state.isFinished()).isEqualTo(false);
    }

    @DisplayName("게임이 끝나지 않은 상태에서(=진행 중) 보상을 받을 수 없다.")
    @Test
    void hitCanNotGetProfit() {
        State state = new Hit(bunchOfCard);

        assertThrows(IllegalArgumentException.class, () -> state.profit(1));
    }

    @DisplayName("Hit 상태에서 드로우를 한 후 카드값의 합이 21 이하이면 Hit 상태가 유지된다")
    @Test
    void keepHit() {
        State state = new Hit(bunchOfCard);
        state = state.draw(new Card(CardTypes.CLOVER_4));

        assertThat(state.getClass()).isEqualTo(Hit.class);
    }

    @DisplayName("Hit 상태에서 드로우를 한 후 카드값의 합이 21 이상이면 Bust 상태로 변경된다")
    @Test
    void hitToBust() {
        State state = new Hit(bunchOfCard);
        state = state.draw(new Card(CardTypes.CLOVER_K));

        assertThat(state.getClass()).isEqualTo(Bust.class);
    }

    @DisplayName("Hit 상태에서 Stay를 하면 Stay 태로 변경된다.")
    @Test
    void hitToStay() {
        State state = new Hit(bunchOfCard);
        state = state.stay();

        assertThat(state.getClass()).isEqualTo(Stay.class);
    }
}
