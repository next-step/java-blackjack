package blackjack.controller;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BlackJackTest {

    @Test
    void 플레이어들의_이름을_입력받아_블랙잭_게임을_생성할_수_있다() {
        List<String> playerNames = Arrays.asList("pobi", "jason", "toby");
        BlackJack blackJack = BlackJack.init(playerNames);
        assertThat(blackJack).isInstanceOf(BlackJack.class);
    }
}
