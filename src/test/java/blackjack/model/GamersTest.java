package blackjack.model;

import blackjack.view.InputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GamersTest {

    @DisplayName("점수 계산 테스트")
    @Test
    void calculateResult() {

        Gamers gamers = new Gamers();
        String[] usersName = {"A","B"};
        gamers.addUsers(usersName);


        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.EIGHT));
        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.ACE));

        for (Player player : gamers.getPlayers()) {
            player.drawCard(Card.of(Type.CLOVER,Symbol.TEN));
            player.drawCard(Card.of(Type.CLOVER,Symbol.TEN));
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

        Gamers gamers = new Gamers();
        String[] usersName = {"A"};
        gamers.addUsers(usersName);
        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.EIGHT));
        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.SIX));
        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.NINE));

        gamers.getUsers().get(0).drawCard(Card.of(Type.CLOVER,Symbol.QUEEN));
        gamers.getUsers().get(0).drawCard(Card.of(Type.CLOVER,Symbol.THREE));
        gamers.getUsers().get(0).drawCard(Card.of(Type.CLOVER,Symbol.KING));
        gamers.calculateResult();

        assertThat(gamers.getDealer().getWinningCount()).isEqualTo(1);
        assertThat(gamers.getUsers().get(0).isWin()).isFalse();
    }
    @DisplayName("블랙잭 무승 테스트")
    @Test
    void calculateResult2() {

        Gamers gamers = new Gamers();
        String[] usersName = {"A"};
        gamers.addUsers(usersName);
        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.ACE));
        gamers.getDealer().drawCard(Card.of(Type.CLOVER,Symbol.QUEEN));

        gamers.getUsers().get(0).drawCard(Card.of(Type.CLOVER,Symbol.QUEEN));
        gamers.getUsers().get(0).drawCard(Card.of(Type.CLOVER,Symbol.ACE));
        gamers.calculateResult();

        assertThat(gamers.getDealer().getWinningCount()).isEqualTo(1);
        assertThat(gamers.getUsers().get(0).isWin()).isFalse();
    }
}