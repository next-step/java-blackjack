package blackjack.domain.report;

import java.util.Collections;
import java.util.List;

public class GameReports {

    private final List<GameReport> reports;

    public GameReports(List<GameReport> reports) {
        this.reports = reports;
    }

    public int getPlayerWinCount() {
        return (int) reports.stream()
            .filter(GameReport::isWin)
            .count();
    }

    public int getPlayerDrawCount() {
        return (int) reports.stream()
            .filter(GameReport::isDraw)
            .count();
    }

    public int getPlayerLoseCount() {
        return (int) reports.stream()
            .filter(GameReport::isLose)
            .count();
    }

    public List<GameReport> reports() {
        return Collections.unmodifiableList(reports);
    }
}
