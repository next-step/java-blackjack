package blackjack.domain;

import blackjack.dto.DealerMatchScoreInfo;
import blackjack.dto.PlayerMatchScoreInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchScoreBoardTest {
    private MatchScoreBoard testScoreBoard;

    @BeforeEach
    void setUp() {
        testScoreBoard = new MatchScoreBoard(
            new LinkedHashMap<>() {{
                put(new Player("name1"), MatchScore.WIN);
                put(new Player("name2"), MatchScore.DRAW);
                put(new Player("name3"), MatchScore.LOSE);
                put(new Player("name4"), MatchScore.WIN);
            }}
        );
    }

    @DisplayName("Check calculated players match score information is proper")
    @Test
    void getPlayersMatchScoreInfo() {
        assertEquals(
            List.of(
                new PlayerMatchScoreInfo("name1", "승"),
                new PlayerMatchScoreInfo("name2", "무"),
                new PlayerMatchScoreInfo("name3", "패"),
                new PlayerMatchScoreInfo("name4", "승")
            ),
            testScoreBoard.getPlayersMatchScoreInfo()
        );
    }

    @DisplayName("Check calculated dealer match score information is proper")
    @Test
    void getDealerScoreInfo() {
        assertEquals(
            new DealerMatchScoreInfo(
                List.of("1승", "1무", "2패")
            ),
            testScoreBoard.getDealerMatchScoreInfo()
        );
    }
}