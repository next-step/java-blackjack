package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class BlackJackTest {

    public static final int GAME_CARD_SIZE = 52;

    @Test
    void GamePlayer를_가진다() {
        List<String> userNames = Arrays.asList("박찬우", "제이슨");
        BlackJack blackJack = BlackJack.from(userNames);
        GameUser gameUser = GameUser.from(userNames);

        List<String> blackJackUserNames = blackJack.getPlayers().stream()
            .map(Player::getName)
            .collect(Collectors.toList());

        List<String> gameUserNames = gameUser.getPlayers().stream()
            .map(Player::getName)
            .collect(Collectors.toList());

        assertThat(blackJackUserNames)
            .isEqualTo(gameUserNames);
    }

    @Test
    void GameCard를_가진다() {
        BlackJack blackJack = BlackJack.from(Arrays.asList());

        assertThat(blackJack.getGameCard().size()).isEqualTo(GAME_CARD_SIZE);
    }

    @Test
    void GameCard를_섞을_수_있다() {
        BlackJack blackJack = BlackJack.from(Arrays.asList());
        GameCard gameCard = GameCard.create();

        assertThat(blackJack.getGameCard()).isNotEqualTo(gameCard.getGameCard());
    }
}
