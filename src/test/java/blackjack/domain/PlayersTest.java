package blackjack.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    private List<Player> playerList;
    private Player pobi;
    private Player jason;
    private Players players;

    @BeforeEach
    void setUp() {
        pobi = new Player("pobi", new Cards(new ArrayList<>()));
        jason = new Player("jason", new Cards(new ArrayList<>()));

        playerList = new ArrayList<>(Arrays.asList(pobi, jason));
        players = new Players(playerList);
    }

    @Test
    void 플레이어별_카드_초기화_결과_검증() {
        Deck deck = Deck.create();
        players.initializeDeck(deck);

        assertAll(
            () -> assertEquals(pobi.cardSize(), 2),
            () -> assertEquals(jason.cardSize(), 2)
        );
    }

    @Test
    void 플레이어가_카드를_더_뽑을_수_있는지_판단할_수_있다() {
        boolean isPobiCanDraw = players.checkActivePlayerCanDrawCard();

        assertThat(isPobiCanDraw).isTrue();
    }

    @Test
    void 활성화된_플레이어의_카드정보를_가져올_수_있다() {
        CardInfo activePlayerCardsInfo = players.getActivePlayerCardInfo();
        CardInfo pobiCardInfo = pobi.openCards();

        assertThat(activePlayerCardsInfo).isEqualTo(pobiCardInfo);

        players.nextActivePlayer();
        activePlayerCardsInfo = players.getActivePlayerCardInfo();
        CardInfo jasonCardInfo = jason.openCards();

        assertThat(activePlayerCardsInfo).isEqualTo(jasonCardInfo);
    }

    @Test
    void 활성화된_플레이어의_이름정보를_가져올_수_있다() {
        NameInfo activePlayerNameInfo = players.getActivePlayerNameInfo();
        NameInfo pobiNameInfo = pobi.nameInfo();

        assertThat(activePlayerNameInfo).isEqualTo(pobiNameInfo);

        players.nextActivePlayer();
        activePlayerNameInfo = players.getActivePlayerNameInfo();
        NameInfo jasonNameInfo = jason.nameInfo();

        assertThat(activePlayerNameInfo).isEqualTo(jasonNameInfo);
    }

    @Test
    void 모든_플레이어의_이름정보를_가져올_수_있다() {
        List<NameInfo> playersName = players.nameInfos();

        NameInfo pobiNameInfo = pobi.nameInfo();
        NameInfo jasonNameInfo = jason.nameInfo();

        assertThat(playersName).containsExactly(pobiNameInfo, jasonNameInfo);
    }

    @Test
    void 플레이어들이_가진_모든_카드정보를_가져올_수_있다() {
        List<CardInfo> cardInfos = players.openCards();

        CardInfo pobiCardInfo = pobi.openCards();
        CardInfo jasonCardInfo = jason.openCards();

        assertThat(cardInfos).containsExactly(pobiCardInfo, jasonCardInfo);
    }

    @Test
    void 플레이어들의_점수정보를_가져올_수_있다() {
        List<ScoreInfo> scoreInfo = players.scoreInfos();

        ScoreInfo pobiScoreInfo = pobi.scoreInfo();
        ScoreInfo jasonScoreInfo = jason.scoreInfo();

        assertThat(scoreInfo).containsExactly(pobiScoreInfo, jasonScoreInfo);
    }

    @Test
    void 더_이상_플레이어가_존재하지_않으면_멈춘다() {
        players.nextActivePlayer();
        players.nextActivePlayer();

        assertThat(players.hasActivePlayer()).isFalse();
    }
}
