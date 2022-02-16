package blackjack.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hands;
import blackjack.domain.card.Pattern;
import blackjack.domain.card.Rank;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어의 현재 점수를 가져온다.")
    @Test
    void Given카드들_When점수_얻기_Then점수_합_반환() {
        final Player player = new Player("jason",
            new Hands(Arrays.asList(
                new Card(Pattern.CLUB, Rank.EIGHT),
                new Card(Pattern.SPADE, Rank.EIGHT))));

        assertThat(player.getScore()).isEqualTo(16);
    }

    @DisplayName("카드를 한장 더 받을 수 있다.")
    @Test
    void Given카드들_When점수가_21미만_Then참_반환() {
        final Player player = new Player("jason",
            new Hands(Arrays.asList(
                new Card(Pattern.CLUB, Rank.EIGHT),
                new Card(Pattern.HEART, Rank.FIVE))));

        assertThat(player.canDraw()).isTrue();
    }

    @DisplayName("카드를 한장 더 받을 수 없다.")
    @Test
    void Given카드들_When점수가_21이상_Then거짓_반환() {
        final Player player = new Player("jason",
            new Hands(Arrays.asList(
                new Card(Pattern.CLUB, Rank.TEN),
                new Card(Pattern.HEART, Rank.ACE))));

        assertThat(player.canDraw()).isFalse();
    }
}