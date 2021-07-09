package blackjack;

import blackjack.model.Player;
import blackjack.model.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    Players players;

    @BeforeEach
    void setUp() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("yerim"));
        playerList.add(new Player("minwoo"));
        players = new Players(playerList);
    }

    @DisplayName(value = "처음 카드를 나눴을 때 모두에게 두 장씩 돌아갔는지")
    @Test
    void all_players_have_two_cards_when_initial_card_setting() {
        players.initialCardSetting();
        for (Player player : players.getPlayers()) {
            assertThat(player.getCards().size()).isEqualTo(2);
        }
    }

    @DisplayName(value = "최고점수 찾기")
    @Test
    void find_max_score() {
        players.initialCardSetting();
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName() + " " + player.score());
        }
        System.out.println("maxScore " + players.findMaxScore());
    }
}
