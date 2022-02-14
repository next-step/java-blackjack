package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
}
