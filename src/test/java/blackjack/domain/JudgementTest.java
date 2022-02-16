package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @DisplayName("플레이어와 딜러의 결과값을 가지고 승자를 찾는다")
    @Test
    void testFindWinner() {
        Map<String, String> playerResults = judgement.findWinners();
        assertThat(playerResults.get("a")).isEqualTo("승");
        assertThat(playerResults.get("b")).isEqualTo("승");
        assertThat(playerResults.get("딜러")).isEqualTo("0승 2패");
    }
}
