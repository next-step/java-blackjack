package blackjack.model;

public class WinningState {

    private int winCount;
    private int loseCount;

    public WinningState() {
        this.winCount = 0;
        this.loseCount = 0;
    }

    public void plusWinCount() {
        this.winCount++;
    }

    public void plusLoseCount() {
        this.loseCount++;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public int getLoseCount() {
        return this.loseCount;
    }
}
