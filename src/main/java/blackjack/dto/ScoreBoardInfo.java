package blackjack.dto;

public class ScoreBoardInfo {

    private final Integer winCount;
    private final Integer drawCount;
    private final Integer loseCount;

    public ScoreBoardInfo(Integer winCount, Integer drawCount, Integer loseCount) {
        this.winCount = winCount;
        this.drawCount = drawCount;
        this.loseCount = loseCount;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public Integer getDrawCount() {
        return drawCount;
    }

    public Integer getLoseCount() {
        return loseCount;
    }
}
