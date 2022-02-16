package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    private CardDeck cardDeck;

    @BeforeEach
    void setUp() {
        cardDeck = new CardDeck();
    }

    @Test
    void 초기_카드덱은_문양숫자조합으로_구별되는_52가지의_카드를_가진다() {
        assertThat(new HashSet<>(cardDeck.initDeck()).size()).isEqualTo(52);
    }

    @Test
    void 한_번_뽑힌_카드는_덱에_존재하지_않아야_한다() {
        Card target = cardDeck.popCard();
        assertThat(cardDeck.contains(target)).isFalse();
    }
}
