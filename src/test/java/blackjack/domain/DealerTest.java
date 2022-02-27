package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import blackjack.domain.card.CardDeck;
import blackjack.domain.player.Dealer;
import blackjack.domain.state.Hit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("딜러_생성_테스트")
    @Test
    void createDealerTest() {
        Dealer dealer = new Dealer("딜러", new Hit(CardDeck.pop(2)));
        assertAll(
            () -> assertThat(dealer.getName()).isEqualTo("딜러"),
            () -> assertThat(dealer).isNotNull()
        );

    }

}