package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class GameUserTest {

    @Test
    void 유저_리스트를_가진다() {
        GameUser gameUser = GameUser.create();
        Dealer dealer = Dealer.create();
        Player p1 = Player.of("제이슨");
        Player p2 = Player.of("박찬우");

        gameUser.append(dealer)
            .append(p1)
            .append(p2);

        assertThat(gameUser.getGameUsers())
            .isEqualTo(Arrays.asList(dealer, p1, p2));
    }
}
