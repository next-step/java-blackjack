package blackjack.domain.card;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardBundleTest {

    @Test
    void 총_52장의_서로_다른_카드를_생성한다() {
        CardBundle cardBundle = new CardBundle();
        List<Card> cards =  cardBundle.createCards();
        assertThat(cards.size()).isEqualTo(52);
        Set<Card> removeDuplicates = new HashSet<>(cards);
        assertThat(removeDuplicates.size()).isEqualTo(52);
    }
}