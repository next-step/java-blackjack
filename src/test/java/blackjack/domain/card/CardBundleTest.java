package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CardBundleTest {

    @Test
    void 카드_번들_내_카드_값의_합을_구할_수_있다() {
        CardBundle cardBundle = CardBundle.emptyBundle();
        cardBundle.addCard(new Card(Suit.HEART, Number.TWO));
        cardBundle.addCard(new Card(Suit.CLOVER, Number.TWO));
        assertThat(cardBundle.calculateScore()).isEqualTo(4);
        cardBundle.addCard(new Card(Suit.DIAMOND, Number.THREE));
        assertThat(cardBundle.calculateScore()).isEqualTo(7);
    }

    @Test
    void 카드_번들_내_ACE가_존재하고_21점_미만이라면_11로_계산한다() {
        CardBundle cardBundle = CardBundle.emptyBundle();
        cardBundle.addCard(new Card(Suit.HEART, Number.ACE));
        cardBundle.addCard(new Card(Suit.CLOVER, Number.TWO));
        assertThat(cardBundle.calculateScore()).isEqualTo(13);
    }
}
