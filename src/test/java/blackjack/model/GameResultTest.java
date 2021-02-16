package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    @Test
    @DisplayName("게임 결과를 테스트")
    void getResultTest() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });

        final GameResult gameResult = new GameResult(players);

        final Result result = gameResult.getResult(players.getPlayers(player -> player.getJob() == Job.GAMER).get(0));
        assertThat(result).isEqualTo(Result.PUSH);
    }

    @Test
    @DisplayName("이긴 결과의 카운팅을 확인하는 테스트")
    void getWinningCountTest() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });

        final GameResult gameResult = new GameResult(players);

        final int winningCount = gameResult.getWinningCount();
        assertThat(winningCount).isEqualTo(0);
    }

    @Test
    @DisplayName("패배 결과의 카운팅을 확인하는 테스트")
    void getLoseCountTest() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });

        final GameResult gameResult = new GameResult(players);

        final int winningCount = gameResult.getLoseCount();
        assertThat(winningCount).isEqualTo(0);
    }

    @Test
    @DisplayName("무승부 결과의 카운팅을 확인하는 테스트")
    void getTieCountTest() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });

        final GameResult gameResult = new GameResult(players);

        final int winningCount = gameResult.getTieCount();
        assertThat(winningCount).isEqualTo(2);
    }
}