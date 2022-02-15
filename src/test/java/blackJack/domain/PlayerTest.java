package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @DisplayName("String 이름이 주어질때, getName 메소드의 값은 주어진 이름과 동일하다.")
    @ParameterizedTest
    @ValueSource(strings = {"이호찬", "박찬우", "holee", "12345"})
    void givenNameWithString_WhenGetName_ThenEqualToGivenName(String name) {
        Player player = Player.of(name);

        assertThat(player.getName())
            .isEqualTo(name);
    }

    @DisplayName("String 이름과 Card가 주어질때 appendToDeck 메소드를 실행시, Card로 만든 리스트와 일치한다.")
    @Test
    void givenPlayerParameter_WhenAppendToDeck_ThenEqualToCardList() {
        Player player = Player.of("제이슨");
        Card card = Card.of("다이아몬드", "2");

        player.appendToDeck(card);

        assertThat(player.getDeck())
            .isEqualTo(Arrays.asList(card));
    }
}