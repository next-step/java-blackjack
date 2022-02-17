package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import blackjack.domain.gamer.Player;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 초기에_카드는_섞여서_2개가_주어진다() {
        Player player = new Player("yangwoo");
        assertThat(player.getCards().size()).isEqualTo(2);
        Player player1 = new Player("seungyun");
        assertThat(player1.getCards().size()).isEqualTo(2);
    }

    @Test
    void ACE는_1이나_11로_계산될_수_있다() {
        Player player = new Player("yang");
        player.getCards().add(new Card(Denomination.ACE, Suit.DIAMONDS));
        player.calcScore(player);
    }
}
