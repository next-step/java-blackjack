package blackjack.domain;

import blackjack.dto.ScoreBoardInfo;

public class ScoreBoard {

    private Integer winCount = 0;
    private Integer drawCount = 0;
    private Integer loseCount = 0;

    //TODO: find a way to remove if statements... azklrsgjaklrjglk 휴,.,
    public Result updateScore(CardBunch dealer, CardBunch player) {
        if (player.calcScore() > dealer.calcScore() && !player.isBust()) {
            loseCount++;
            return Result.WIN;
        }

        if (player.calcScore().equals(dealer.calcScore())) {
            drawCount++;
            return Result.DRAW;
        }

        if (player.calcScore() < dealer.calcScore() && !dealer.isBust()) {
            winCount++;
            return Result.LOSE;
        }

        if (!player.isBust() && dealer.isBust()) {
            loseCount++;
            return Result.WIN;
        }

        winCount++;
        return Result.LOSE;
    }

    public ScoreBoardInfo getScoreBoardInfo() {
        return new ScoreBoardInfo(winCount, drawCount, loseCount);
    }
}
