package blackjack.domain.gameplayer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    public void 중복된_이름은_들어올_수_없다() {
        //given
        final String DUPLICATE_NAMES = "중복된 이름은 들어올 수 없습니다.";

        //when

        //then
        assertThatThrownBy(() -> new Names(Arrays.asList(new Name("pobi"), new Name("pobi"))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATE_NAMES);
    }
}