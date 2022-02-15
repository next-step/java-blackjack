package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    void 딜러인지_확인할_수_있다() {
        Dealer dealer = new Dealer();
        assertThat(dealer.isDealer()).isTrue();
        assertThat(dealer.isPlayer()).isFalse();
    }

    @Test
    void 딜러가_가진_패의_합을_확인_할_수_있다() {
        Dealer dealer = new Dealer();
        dealer.drawCard(new Card(Suit.CLOVER, Number.FIVE));
        dealer.drawCard(new Card(Suit.CLOVER, Number.SIX));
        assertThat(dealer.score()).isEqualTo(11);
    }

    @Test
    void 딜러가_가진_패의_합이_16이하라면_패를_뽑아야_한다() {
        Dealer dealer = new Dealer();
        dealer.drawCard(new Card(Suit.CLOVER, Number.FIVE));
        dealer.drawCard(new Card(Suit.CLOVER, Number.SIX));
        assertThat(dealer.isDrawable()).isTrue();
    }

    @Test
    void 딜러가_가진_패의_합이_21이상이라면_패배한다() {
        Dealer dealer = new Dealer();
        dealer.drawCard(new Card(Suit.CLOVER, Number.FIVE));
        dealer.drawCard(new Card(Suit.CLOVER, Number.SEVEN));
        dealer.drawCard(new Card(Suit.DIAMOND, Number.JACK));
        assertThat(dealer.isBurst()).isTrue();
    }
}
