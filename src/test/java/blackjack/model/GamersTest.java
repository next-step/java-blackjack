package blackjack.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GamersTest {

    private static Map<String,Integer> userAndMoney;
    private static Gamers gamers;

    @BeforeAll
    static void init() {
        gamers = new Gamers();
        userAndMoney = new HashMap<>();
        userAndMoney.put("A",20000);
        userAndMoney.put("B",10000);
        gamers.addUsers(userAndMoney);
    }

    @DisplayName("점수 계산 테스트")
    @Test
    void calculateResult() {


        gamers.getDealer().drawCard(Fixtures.HEART_EIGHT_CARD);
        gamers.getDealer().drawCard(Fixtures.HEART_ACE_CARD);

        for (Player player : gamers.getPlayers()) {
            player.drawCard(Fixtures.HEART_TEN_CARD);
            player.drawCard(Fixtures.HEART_TEN_CARD);
        }
        gamers.calculateResult();

        assertThat(gamers.getDealer().getWinningCount()).isEqualTo(0);
        assertThat(gamers.getDealer().getLosingCount()).isEqualTo(2);
        assertThat(gamers.getUsers().get(0).isWin()).isTrue();
        assertThat(gamers.getUsers().get(1).isWin()).isTrue();
    }
    @DisplayName("블랙잭 초과 승부 테스트")
    @Test
    void calculateResult1() {

        gamers.getDealer().drawCard(Fixtures.HEART_EIGHT_CARD);
        gamers.getDealer().drawCard(Fixtures.HEART_SIX_CARD);
        gamers.getDealer().drawCard(Fixtures.HEART_NINE_CARD);

        gamers.getUsers().get(0).drawCard(Fixtures.HEART_TEN_CARD);
        gamers.getUsers().get(0).drawCard(Fixtures.HEART_THREE_CARD);
        gamers.getUsers().get(0).drawCard(Fixtures.HEART_TEN_CARD);
        gamers.calculateResult();

        assertThat(gamers.getDealer().getWinningCount()).isEqualTo(1);
        assertThat(gamers.getUsers().get(0).isWin()).isFalse();
    }
    @DisplayName("블랙잭 무승 테스트")
    @Test
    void calculateResult2() {

        gamers.getDealer().drawCard(Fixtures.HEART_ACE_CARD);
        gamers.getDealer().drawCard(Fixtures.HEART_TEN_CARD);

        gamers.getUsers().get(0).drawCard(Fixtures.HEART_TEN_CARD);
        gamers.getUsers().get(0).drawCard(Fixtures.HEART_ACE_CARD);
        gamers.getUsers().get(1).drawCard(Fixtures.HEART_TEN_CARD);
        gamers.getUsers().get(1).drawCard(Fixtures.HEART_ACE_CARD);
        gamers.calculateResult();

        assertThat(gamers.getDealer().getWinningCount()).isEqualTo(2);
        assertThat(gamers.getUsers().get(0).isWin()).isFalse();
    }
}