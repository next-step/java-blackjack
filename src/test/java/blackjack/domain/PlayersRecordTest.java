package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersRecordTest {

    @DisplayName("딜러에 대한 플레이어 승패 테스트: 딜러 20 vs 플레이어 19, 패")
    @Test
    void winOrLoseTestWhenLose() {
        // given
        int dealerScore = 20;
        int playerScore = 19;
        PlayersRecord playersRecord = new PlayersRecord(new Dealer(), new ArrayList<>());

        // when

        // then
        assertThat(playersRecord.winOrLose(dealerScore, playerScore)).isEqualTo("패");
    }

    @DisplayName("딜러에 대한 플레이어 승패 테스트: 딜러 22 vs 플레이어 19, 승")
    @Test
    void winOrLoseTestWhenWin() {
        // given
        int dealerScore = 22;
        int playerScore = 19;
        PlayersRecord playersRecord = new PlayersRecord(new Dealer(), new ArrayList<>());

        // when

        // then
        assertThat(playersRecord.winOrLose(dealerScore, playerScore)).isEqualTo("승");
    }
}
