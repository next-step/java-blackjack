package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CardNumberTest {

    @DisplayName("주어진 String으로 CardNumber 생성 후 getCardNumber() 호출시, 주어진 정수와 동일하다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"})
    void givenNumberWithString_WhenGetCardNumber_ThenEqualToGivenNumber(String number) {
        CardNumber cardNumber = CardNumber.from(number);

        assertThat(cardNumber.getCardNumber())
            .isEqualTo(number);
    }

    @DisplayName("유효하지 않는 CarNumber 범위로 인스턴스가 생성될때, RuntimeException 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "12", "13", "B"})
    void givenInValidCardNumberRange_WhenCreateInstance_ThenThrowRuntimeException(
        String number) {
        assertThatThrownBy(() -> CardNumber.from(number))
            .isInstanceOf(RuntimeException.class);

    }
}