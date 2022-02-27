package blackjack.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void 해당_카드가_에이스인지_알_수_있다() {
        Card card = new Card(CardNumber.ACE, Suit.CLUB);

        boolean result = card.isAce();

        assertThat(result).isTrue();
    }

    @Test
    void 해당_카드가_몇점인지_알_수_있다() {
        Card card = new Card(CardNumber.KING, Suit.CLUB);

        int score = card.getCardScore();

        assertThat(score).isEqualTo(10);
    }

}
