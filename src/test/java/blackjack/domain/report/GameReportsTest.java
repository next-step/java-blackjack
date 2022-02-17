package blackjack.domain.report;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameReportsTest {

    static GameReports gameReports;

    @BeforeAll
    static void setup() {
        List<GameReport> reports = new ArrayList<>();
        reports.add(new GameReport("tester1", GameResult.WIN));
        reports.add(new GameReport("tester2", GameResult.WIN));
        reports.add(new GameReport("tester3", GameResult.WIN));
        reports.add(new GameReport("tester4", GameResult.DRAW));
        reports.add(new GameReport("tester5", GameResult.DRAW));
        reports.add(new GameReport("tester6", GameResult.LOSE));
        gameReports = new GameReports(reports);
    }

    @Test
    void 게임_결과_보고들의_승리_수를_구할_수_있다() {
        assertThat(gameReports.getPlayerWinCount()).isEqualTo(3);
    }

    @Test
    void 게임_결과_보고들의_무승부_수를_구할_수_있다() {
        assertThat(gameReports.getPlayerDrawCount()).isEqualTo(2);
    }

    @Test
    void 게임_결과_보고들의_패배_수를_구할_수_있다() {
        assertThat(gameReports.getPlayerLoseCount()).isEqualTo(1);
    }
}