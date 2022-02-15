package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CardNumberTest {

    @DisplayName("주어진 정수로 CardNumber 생성 후 getCardNumber() 호출시, 주어진 정수와 동일하다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"})
    void givenNumberWithInt_WhenGetCardNumber_ThenEqualToGivenNumber(String number) {
        CardNumber cardNumber = CardNumber.from(number);

        assertThat(cardNumber.getCardNumber())
            .isEqualTo(number);
    }
}