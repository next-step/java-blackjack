package BlackJack.game;

public class WinnerResultDealer {
    private int winCount = 0;
    private int loseCount = 0;

    public void resultCount(boolean playerResult) {
        if (playerResult) {
            this.loseCount++;
            return;
        }
        this.winCount++;
        return;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }
}
