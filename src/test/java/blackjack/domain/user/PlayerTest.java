package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"jason", "pobi"})
    void 이름을_가진_플레이어를_생성한다(String name) {
        Player player = new Player(name);
        assertThat(player.name()).isEqualTo(name);
    }

    @Test
    void 이름은_공백이_들어올_수_없다() {
        assertThatThrownBy(() -> new Player(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    void 해당_플레이어가_딜러인지_확인할_수_있다() {
        Player player = new Player("name");
        assertThat(player.isDealer()).isFalse();
        assertThat(player.isPlayer()).isTrue();
    }

    @Test
    void 플레이어_카드의_합을_구할_수_있다() {
        Player player = new Player("name");
        player.drawCard(new Card(Suit.CLOVER, Number.FIVE));
        player.drawCard(new Card(Suit.CLOVER, Number.SEVEN));
        assertThat(player.score()).isEqualTo(12);
    }

    @Test
    void 플레이어_카드의_합이_21초과라면_패배한다() {
        Player player = new Player("name");
        player.drawCard(new Card(Suit.CLOVER, Number.EIGHT));
        player.drawCard(new Card(Suit.CLOVER, Number.SEVEN));
        player.drawCard(new Card(Suit.CLOVER, Number.NINE));
        assertThat(player.isBurst()).isTrue();
    }

    @Test
    void 플레이어_카드의_합이_21이라면_승리한다() {
        Player player = new Player("name");
        player.drawCard(new Card(Suit.CLOVER, Number.FIVE));
        player.drawCard(new Card(Suit.CLOVER, Number.SEVEN));
        player.drawCard(new Card(Suit.CLOVER, Number.NINE));
        assertThat(player.isBlackJack()).isTrue();
    }
}