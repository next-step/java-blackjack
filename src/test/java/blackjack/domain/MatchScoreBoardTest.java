package blackjack.domain;

import blackjack.dto.DealerScoreInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PlayerScoreInfo;
import blackjack.dto.PlayersScoreInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MatchScoreBoardTest {
    private MatchScoreBoard testScoreBoard;

    @BeforeEach
    void setUp() {
        testScoreBoard = new MatchScoreBoard(
            new HashMap<>() {{
                put(new Player("name1"), MatchScore.WIN);
                put(new Player("name2"), MatchScore.DRAW);
                put(new Player("name3"), MatchScore.LOSE);
                put(new Player("name4"), MatchScore.WIN);
            }}
        );
    }

    @DisplayName("Check calculated players score information is proper")
    @Test
    void getPlayersScoreInfo() {
        assertEquals(
            new PlayersScoreInfo(
                Set.of(
                    new PlayerScoreInfo(new NameInfo("name1"), "승"),
                    new PlayerScoreInfo(new NameInfo("name2"), "무"),
                    new PlayerScoreInfo(new NameInfo("name3"), "패"),
                    new PlayerScoreInfo(new NameInfo("name4"), "승")
                )
            ),
            testScoreBoard.getPlayersScoreInfo()
        );
    }

    @DisplayName("Check calculated dealer score information is proper")
    @Test
    void getDealerScoreInfo() {
        assertEquals(
            new DealerScoreInfo(
                List.of("1승", "1무", "2패")
            ),
            testScoreBoard.getDealerScoreInfo()
        );
    }
}