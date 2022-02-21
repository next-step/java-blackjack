package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CardNumberTest {

    @DisplayName("주어진 String으로 CardNumber 생성 후 getCardNumber() 호출시, 주어진 정수와 동일하다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"})
    void givenNumberWithString_WhenGetCardNumber_ThenEqualToGivenNumber(String number) {
        CardNumber cardNumber = CardNumber.from(number);

        assertThat(cardNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("유효하지 않는 CardNumber 범위로 인스턴스가 생성될때, RuntimeException 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "12", "13", "B"})
    void givenInValidCardNumberRange_WhenCreateInstance_ThenThrowRuntimeException(String number) {
        assertThatThrownBy(() -> CardNumber.from(number))
            .isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> generateCardTypeAndAceNumber() {
        return Stream.of(
            Arguments.of("A", 1),
            Arguments.of("3", 3),
            Arguments.of("4", 4),
            Arguments.of("5", 5),
            Arguments.of("6", 6),
            Arguments.of("J", 10),
            Arguments.of("Q", 10),
            Arguments.of("K", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("generateCardTypeAndAceNumber")
    void 스코어를_계산할_수_있다(String cardType, int score) {
        CardNumber cardNumber = CardNumber.from(cardType);

        assertThat(cardNumber.calculateScore()).isEqualTo(score);
    }
}
