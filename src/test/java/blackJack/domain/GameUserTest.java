package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class GameUserTest {

    private static final String DEALER_DEFAULT_NAME = "dealer";

    @Test
    void GameUser의_Dealer의_이름은_dealer이다() {
        GameUser gameUser = GameUser.from(Arrays.asList());
        String dealerName = gameUser.getDealer().getName();

        assertThat(dealerName)
            .isEqualTo(DEALER_DEFAULT_NAME);
    }

    @Test
    void GameUser는_Player_리스트를_가진다() {
        List<String> userNames = Arrays.asList("제이슨", "박찬우");
        GameUser gameUser = GameUser.from(userNames);
        List<String> gameUserNames = gameUser.getPlayers().stream()
            .map(User::getName)
            .collect(Collectors.toList());

        assertThat(userNames)
            .isEqualTo(gameUserNames);
    }
}
