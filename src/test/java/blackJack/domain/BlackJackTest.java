package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackJackTest {

    public static final int GAME_CARD_SIZE = 52;

    @Test
    void GamePlayer를_가진다() {
        List<String> userNames = Arrays.asList("박찬우", "제이슨");
        BlackJack blackJack = BlackJack.from(userNames);
        GameUser gameUser = GameUser.from(userNames);

        List<String> blackJackUserNames = blackJack.getPlayers().stream()
            .map(player -> player.getName())
            .collect(Collectors.toList());

        List<String> gameUserNames = gameUser.getPlayers().stream()
            .map(player -> player.getName())
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

    @DisplayName("Dealer는 총 score가 16이하일 경우, 1장의 카드를 추가로 받는다.")
    @Test
    void Dealer는_Score가_16이상일떄_1장을_더_받는다() {

    }
}
