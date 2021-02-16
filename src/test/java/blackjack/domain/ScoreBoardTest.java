package blackjack.domain;

import blackjack.dto.ScoreBoardInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @DisplayName("Test if the methods returns correct score for dealers")
    @Test
    void updateScore() {
        Result result = scoreBoard.updateScore(
                new CardBunch(List.of(10, 10, 2), Suit.HEARTS),
                new CardBunch(List.of(10, 6), Suit.HEARTS)
        );

        assertEquals(
                new ScoreBoardInfo(0, 0, 1).getLoseCount(),
                scoreBoard.getScoreBoardInfo().getLoseCount()
        );
    }

    @DisplayName("Test if the method returns correct result for players")
    @Test
    void resultTest() {
        Result result = scoreBoard.updateScore(
                new CardBunch(List.of(10, 10, 2), Suit.HEARTS),
                new CardBunch(List.of(10, 6), Suit.HEARTS)
        );
        assertEquals(Result.WIN, result);
    }
}