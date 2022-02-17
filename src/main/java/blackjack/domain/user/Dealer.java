package blackjack.domain.user;

import blackjack.domain.report.GameReport;

public class Dealer extends Player {

    private static final int DEALER_MUST_DRAW_SCORE = 16;

    public Dealer() {
        super("딜러");
    }

    public GameReport createReport(Player player) {
        return null;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public boolean isDealer() {
        return true;
    }

    @Override
    public boolean isDrawable() {
        return score() <= DEALER_MUST_DRAW_SCORE;
    }
}
