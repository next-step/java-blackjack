package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningStateTest {

    @DisplayName("WinningState 생성 검증")
    @Test
    void generateWinningStateTest() {
        assertDoesNotThrow(() -> new WinningState());
    }

    @DisplayName("WinningState 데이터 get 검증")
    @Test
    void getStateTest() {
        WinningState winningState = new WinningState();

        winningState.plusWinCount();
        winningState.plusLoseCount();
        winningState.plusDrawCount();

        assertAll(
                () -> assertThat(winningState.getLoseCount()).isEqualTo(1),
                () -> assertThat(winningState.getWinCount()).isEqualTo(1),
                () -> assertThat(winningState.getDrawCount()).isEqualTo(1)
        );
    }
}
