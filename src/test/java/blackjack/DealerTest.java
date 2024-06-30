package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    void 카드_합이_n이상_검사(){
        final Dealer dealer = new Dealer();
        dealer.deal(dealer);
        Integer actual =  dealer.getSum();
        assertThat(actual).isLessThan(11);
    }

    @Test
    void 카드_합이_16_이하() {
        Dealer dealer = new Dealer();

    }
}
