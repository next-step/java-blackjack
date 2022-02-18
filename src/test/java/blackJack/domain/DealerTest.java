package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("Dealer의 기본 이름은 dealer 이다.")
    @Test
    void givenDefaultName_WhenGetName_ThenEqualToGivenName() {
        Dealer dealer = Dealer.create();

        assertThat(dealer.getName())
            .isEqualTo("딜러");
    }

    @DisplayName("String 이름과 Card가 주어질때 appendToDeck 메소드를 실행시, Card로 만든 리스트와 일치한다.")
    @Test
    void givenDealerParameter_WhenAppendToDeck_ThenEqualToCardList() {
        Dealer dealer = Dealer.create();
        Card card = Card.of("다이아몬드", "2");

        dealer.appendToDeck(card);

        assertThat(dealer.getDeck())
            .isEqualTo(Arrays.asList(card));
    }
}
