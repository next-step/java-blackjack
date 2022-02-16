package blackjack.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("딜러_생성_테스트")
    @Test
    void createDealerTest() {
        Dealer dealer = new Dealer("딜러", new Cards(CardDeck.pop(2)));
        assertAll(
            ()->assertThat(dealer.getName()).isEqualTo("딜러"),
            ()->assertThat(dealer).isNotNull()
        );
    }
}