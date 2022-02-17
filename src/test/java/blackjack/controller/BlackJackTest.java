package blackjack.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.domain.request.UserNamesRequest;
import org.junit.jupiter.api.Test;

class BlackJackTest {

    @Test
    void 플레이어들의_이름을_입력받아_블랙잭_게임을_생성할_수_있다() {
        String playerNames = "pobi, jason, toby";
        BlackJack blackJack = BlackJack.init(UserNamesRequest.from(playerNames));
        assertThat(blackJack).isInstanceOf(BlackJack.class);
    }
}
