package blackjack.domain.gamer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GamerTest {

    @Test
    void 모든_게이머는_처음에_2장의_카드를_받는다() {
        Gamer player = new Player("yang");
        Gamer dealer = new Dealer();
        assertThat(player.getCards().size()).isEqualTo(2);
        assertThat(dealer.getCards().size()).isEqualTo(2);
    }

    @Test
    void 플레이어의_카드_총합을_계산한다() {
        Gamer player = new Player("yang", Arrays.asList(new Card(Denomination.FOUR, Suit.DIAMONDS),
            new Card(Denomination.NINE, Suit.DIAMONDS)));
        assertThat(player.calcScore(player)).isEqualTo(13);
    }

    @Test
    void ACE는_1이나_11로_계산될_수_있다() {
        Gamer player = new Player("yang", Arrays.asList(new Card(Denomination.FOUR, Suit.DIAMONDS),
            new Card(Denomination.ACE, Suit.DIAMONDS)));
        assertThat(player.calcScore(player)).isEqualTo(15);
    }

    @Test
    void 플레이어는_카드를_한_장더_받을_수_있다() {
        Gamer player = new Player("yang");
        assertThat(player.addCard(player.getCards()).size()).isEqualTo(3);
    }


}
