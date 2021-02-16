package blackjack.domain;

public abstract class RecordRule {
    private static final int BLACKJACK = 21;

    public static boolean playerWin(final int dealerScore, final int playerScore) {
        return (playerScore < dealerScore && dealerScore <= BLACKJACK) || playerScore > BLACKJACK;
    }

    public static boolean playerDraw(final int dealerScore, final int playerScore) {
        return playerScore == dealerScore && dealerScore != BLACKJACK;
    }
}
