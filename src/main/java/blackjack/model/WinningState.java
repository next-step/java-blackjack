package blackjack.model;

public class WinningState {
    private int winCount;
    private int loseCount;
    private int drawCount;

    public WinningState() {
        this.winCount = 0;
        this.loseCount = 0;
        this.drawCount = 0;
    }

    public void plusWinCount() {
        this.winCount++;
    }

    public void plusLoseCount() {
        this.loseCount++;
    }

    public void plusDrawCount() {
        this.drawCount++;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public int getLoseCount() {
        return this.loseCount;
    }

    public int getDrawCount() {
        return this.drawCount;
    }
}
