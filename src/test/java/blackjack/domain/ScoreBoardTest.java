package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.dto.MatchInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {

    Map<Player, Score> scoreMap;
    Dealer dealer;
    Deck deck = Deck.create();
    ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
        dealer.initializeDeck(deck);

        scoreMap = new LinkedHashMap<>() {{
            put(new Player("pobi"), Score.LOSE);
            put(new Player("지워니"), Score.WIN);
            put(new Player("jason"), Score.LOSE);
        }};
        scoreBoard = new ScoreBoard(scoreMap);
    }

    @Test
    void 딜러의_경기_결과를_얻어낼_수_있다() {
        MatchInfo dealerMatchInfo = scoreBoard.dealerMatches(dealer);
        MatchInfo matchInfo = new MatchInfo("딜러", "2승 1패");

        assertThat(dealerMatchInfo.getMatches()).isEqualTo(matchInfo.getMatches());
    }

    @Test
    void 모든_플레이어의_경기_결과를_얻어낼_수_있다() {
        List<MatchInfo> playersMatchInfo = scoreBoard.playerMatches();
        MatchInfo pobiMatchInfo = new MatchInfo("pobi", "패");
        MatchInfo jiWoniMatchInfo = new MatchInfo("지워니", "승");
        MatchInfo jasonMatchInfo = new MatchInfo("jason", "패");

        assertThat(playersMatchInfo).containsExactly(pobiMatchInfo, jiWoniMatchInfo,
            jasonMatchInfo);
    }

}
