package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {
    @DisplayName("플레이어들의 이름을 출력하는 테스트")
    @ParameterizedTest(name = "{1}번 째 플레이어 => 이름: {0}")
    @CsvSource({"Dealer, 0", "HAKZZANG, 1", "covenant, 2"})
    void getPlayersTests(String inputPlayerName, int index) {
        final Players players = new Players("HAKZZANG, covenant");
        final List<Player> playerList = players.getPlayers(player -> true);
        final Player player = playerList.get(index);
        final String playerName = player.getName();
        assertThat(playerName).contains(inputPlayerName);
    }
}