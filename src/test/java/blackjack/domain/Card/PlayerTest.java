package blackjack.domain.Card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 초기에_카드는_섞여서_2개가_주어진다() {
        Player player = new Player("yangwoo");
        assertThat(player.getCards().size()).isEqualTo(2);
        Player player1 = new Player("seungyun");
        assertThat(player1.getCards().size()).isEqualTo(2);
    }
}
