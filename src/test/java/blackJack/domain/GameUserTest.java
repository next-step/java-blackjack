package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class GameUserTest {

    private static final String DEALER_DEFAULT_NAME = "dealer";

    @Test
    void 유저_리스트는_기본적으로_dealer를_가진다() {
        GameUser gameUser = GameUser.from(Arrays.asList());

        List<String> gameUserNames = gameUser.getGameUsers().stream()
            .map(user -> user.getName())
            .collect(Collectors.toList());

        assertThat(gameUserNames.get(0))
            .isEqualTo(DEALER_DEFAULT_NAME);
    }

    @Test
    void 유저_리스트를_가진다() {
        List<String> userNames = Arrays.asList("제이슨", "박찬우");

        GameUser gameUser = GameUser.from(userNames);
        Dealer dealer = Dealer.create();
        Player p1 = Player.of("제이슨");
        Player p2 = Player.of("박찬우");

        List<String> gameUserNames = gameUser.getGameUsers().stream()
            .map(user -> user.getName())
            .collect(Collectors.toList());

        assertThat(userNames)
            .isSubsetOf(gameUserNames);
    }
}
