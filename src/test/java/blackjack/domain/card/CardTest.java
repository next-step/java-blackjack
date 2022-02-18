package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    @DisplayName("카드 이름을 반환한다.")
    @Test
    void When카드이름_얻기_Then이름_반환() {
        assertThat(new Card(Pattern.SPADE, Rank.SEVEN).getName()).isEqualTo("7스페이드");
    }

    @DisplayName("ACE이면 true 반환한다.")
    @Test
    void Given에이스_When판단_Then참() {
        assertThat(new Card(Pattern.SPADE, Rank.ACE).isAce()).isTrue();
    }

    @DisplayName("ACE가 아니면 false를 반환한다.")
    @Test
    void Given에이스_이외의_카드_When판단_Then거짓() {
        assertThat(new Card(Pattern.SPADE, Rank.KING).isAce()).isFalse();
    }
}
