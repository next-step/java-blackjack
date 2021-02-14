package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExporterTest {
    @Test
    @DisplayName("초기 카드 배분 테스트")
    void initialCardDistributionTest() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(Player::receiveCard);
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        final Exporter exporter = new Exporter(players);
        final String initialCardDistribution = exporter.initialCardDistribution();

        assertThat(initialCardDistribution).isEqualTo(
                "Dealer와 HAKZZANG, covenant에게 2장을 나누었습니다.\n" +
                        "Dealer : K클로버\n" +
                        "HAKZZANG : K스페이드, K하트\n" +
                        "covenant : K다이아몬드, Q클로버"
        );
    }

    @Test
    @DisplayName("플레이어가 소유한 카드와 점수 테스트")
    void getPlayersCardsStatusWithScore() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });

        final Exporter exporter = new Exporter(players);
        final String playersCardsStatusWithScore = exporter.getPlayersCardsStatusWithScore();

        assertThat(playersCardsStatusWithScore).isEqualTo(
                "Dealer : K클로버, K스페이드 - 결과 : 20\n" +
                        "HAKZZANG : K하트, K다이아몬드 - 결과 : 20\n" +
                        "covenant : Q클로버, Q스페이드 - 결과 : 20"
        );
    }

    @Test
    @DisplayName("최종 승패 테스트")
    void resultTest() {
        final Players players = new Players("HAKZZANG, covenant", new EmptyShuffleStrategy());
        players.getPlayers(player -> player.getJob() == Job.DEALER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(player -> {
            player.receiveCard();
            player.receiveCard();
        });

        final Exporter exporter = new Exporter(players);
        final String result = exporter.getResult();

        assertThat(result).isEqualTo(
                "딜러: 2승, 0패\n" +
                "HAKZZANG: 패\n" +
                "covenant: 패\n"
        );
    }
}