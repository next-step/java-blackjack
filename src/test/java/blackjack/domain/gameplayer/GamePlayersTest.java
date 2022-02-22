package blackjack.domain.gameplayer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class GamePlayersTest {

    @Test
    public void 입력된_플레이어이름으로_게임플레이어객체가_생성된다() {
        //given
        List<String> names = Arrays.asList("pobi", "jason");

        //when
        GamePlayers gamePlayers = GamePlayers.makePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        List<String> players = gamePlayers.getPlayers().stream()
            .map(GamePlayer::getName)
            .collect(Collectors.toList());

        //then
        assertThat(players).contains(names.toArray(new String[0]));
    }
}