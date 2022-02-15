package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CardTypeTest {
    @DisplayName("주어진 String type 으로 CardType 생성 후 getCardType() 호출시, 주어진 type과 동일하다.")
    @ParameterizedTest
    @ValueSource(strings = {"다이아몬드", "하트", "스페이드", "클로버"})
    void givenCardTypeWithString_WhenGetCardType_ThenEqualToGivenCardType(String type) {
        CardType cardType = CardType.from(type);

        assertThat(cardType.getCardType())
            .isEqualTo(type);
    }
}