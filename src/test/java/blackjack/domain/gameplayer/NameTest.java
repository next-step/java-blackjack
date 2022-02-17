package blackjack.domain.gameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    public void 이름은_공백이_들어올_수_없다() {
        //given
        String PLAYER_NAME_ERROR_MESSAGE = "이름은 공백이 들어올 수 없습니다.";

        //when

        //then
        Assertions.assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PLAYER_NAME_ERROR_MESSAGE);
    }
}