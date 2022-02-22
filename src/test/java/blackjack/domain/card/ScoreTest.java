package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @DisplayName("파라미터로 값이 없으면 초기 Score로 설정한다.")
    @Test
    void GivenNothing_When객체_생성_Then_초기_값을_가진_객체() {
        assertThat(new Score().getValue()).isEqualTo(0);
    }

    @DisplayName("값을 받아 객체를 생성한다.")
    @Test
    void Given값_When객체_생성_Then넘겨받은_값을_가진_객체() {
        assertThat(new Score(7).getValue()).isEqualTo(7);
    }

    @DisplayName("값을 받아 기존의 값과 더한 객체를 반환한다.")
    @Test
    void Given값_When객체_생성_Then기존_값과_들어온_값을_가진_객체() {
        // Given
        final Score score = new Score(1);

        final Score newScore = score.sum(7);
        assertThat(newScore.getValue()).isEqualTo(8);
    }
}
