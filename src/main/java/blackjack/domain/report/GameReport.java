package blackjack.domain.report;

import java.util.Objects;

public class GameReport {

    private final String name;
    private final GameResult result;

    public GameReport(String name, GameResult result) {
        this.name = name;
        this.result = result;
    }

    public String name() {
        return name;
    }

    public String message() {
        return result.message();
    }

    public boolean isWin() {
        return result == GameResult.WIN;
    }

    public boolean isDraw() {
        return result == GameResult.DRAW;
    }

    public boolean isLose() {
        return result == GameResult.LOSE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameReport report = (GameReport) o;
        return Objects.equals(name, report.name) && result == report.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, result);
    }
}
